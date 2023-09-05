package org.fancylynx.application.viewmodel;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchBarViewModel {
    public interface SearchListener {
        void search(String searchString);
    }

    private List<SearchListener> listeners = new ArrayList<>();

    private final StringProperty searchString = new SimpleStringProperty("");
    private final BooleanBinding isSearchDisabledBinding = Bindings.createBooleanBinding( ()-> false );

    public SearchBarViewModel() {
        searchString.addListener( (arg, oldVal, newVal)->isSearchDisabledBinding.invalidate() );
        /*mapQuestService.setMapUpdate((byteArray) -> {
            imageField.setBytes(byteArray);
        }) */
    }


    public StringProperty searchStringProperty() {
        return searchString;
    }

    public BooleanBinding searchDisabledBinding() {
        return isSearchDisabledBinding;
    }

    public void addSearchListener(SearchListener listener) {
        listeners.add(listener);
    }

    public void removeSearchListener(SearchListener listener) {
        listeners.remove(listener);
    }

    public void doSearch() {
        for (var listener : listeners ) {
            listener.search(searchString.get());
        }
    }
}