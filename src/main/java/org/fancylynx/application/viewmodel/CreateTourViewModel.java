package org.fancylynx.application.viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.fancylynx.application.model.DataModel;
import org.springframework.stereotype.Component;

// 2do: make component, dependency injection
@Component
public class CreateTourViewModel {
    private final DataModel model;
    private final IntegerProperty TESTINT;
    private final IntegerProperty TESTINT_2;
    private final StringProperty TEST_OUTPUT;


    public CreateTourViewModel(DataModel model) {
        this.model = model;
        TESTINT = new SimpleIntegerProperty();
        TESTINT_2 = new SimpleIntegerProperty();
        TEST_OUTPUT = new SimpleStringProperty();

    }

    public IntegerProperty TESTINTProperty() {
        return TESTINT;
    }

    public IntegerProperty TESTINT_2Property() {
        return TESTINT_2;
    }

    public StringProperty TEST_OUTPUTProperty() {
        return TEST_OUTPUT;
    }

    public void setTEST_OUTPUT(String TEST_OUTPUT) {
        this.TEST_OUTPUT.set(TEST_OUTPUT);
    }
}
