package org.fancylynx.application.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.service.RouteService;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.springframework.stereotype.Component;

@Component
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
    private RouteService routeService;
    private TourModelNew tourModelNew;

    public TourDetailsViewModel(TourServiceNew tourServiceNew, RouteService routeService) {
        this.tourServiceNew = tourServiceNew;
        this.routeService = routeService;
    }

    public void setTour(TourModelNew tourModelNew) {
        if (tourModelNew == null) {
            name.setValue("");
            return;
        }

        this.tourModelNew = tourModelNew;
        name.set(tourModelNew.getName());
        description.set(tourModelNew.getDescription());
        from.set(tourModelNew.getFrom());
        to.set(tourModelNew.getTo());
        type.set(tourModelNew.getTransportType());
        distance.set(tourModelNew.getDistance());
        estimatedTime.set(tourModelNew.getEstimatedTime());
        imagePath.set(tourModelNew.getImagePath());
    }

    public void saveTour() {
        setValues();

        String sessionId = routeService.getRoute(tourModelNew);
        String imagePath = routeService.getStaticMap(sessionId);
        tourModelNew.setImagePath(imagePath);

        tourServiceNew.updateTour(tourModelNew);
    }

    public void setValues() {
        tourModelNew.setName(name.get());
        tourModelNew.setDescription(description.get());
        tourModelNew.setFrom(from.get());
        tourModelNew.setTo(to.get());
        tourModelNew.setTransportType(type.get());
        tourModelNew.setDistance(distance.get());
        tourModelNew.setEstimatedTime(estimatedTime.get());
        tourModelNew.setImagePath(imagePath.get());
    }

}
