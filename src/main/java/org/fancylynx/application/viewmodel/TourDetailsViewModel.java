package org.fancylynx.application.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.service.TourServiceNew;

public class TourDetailsViewModel {
    @Getter
    private final StringProperty name = new SimpleStringProperty();
    @Getter
    private final StringProperty description = new SimpleStringProperty();
    @Getter
    private final StringProperty from = new SimpleStringProperty();
    @Getter
    private final StringProperty to = new SimpleStringProperty();
    @Getter
    private final StringProperty type = new SimpleStringProperty();
    @Getter
    private final StringProperty distance = new SimpleStringProperty();
    @Getter
    private final StringProperty estimatedTime = new SimpleStringProperty();
    @Getter
    private final StringProperty imagePath = new SimpleStringProperty();

    private TourServiceNew tourServiceNew;
    private TourModelNew tourModelNew;

    public TourDetailsViewModel(TourServiceNew tourServiceNew) {
        this.tourServiceNew = tourServiceNew;
    }

    public void setTourModel(TourModelNew tourModelNew) {
        this.tourModelNew = tourModelNew;
    }

}
