package org.fancylynx.application.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import lombok.Getter;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.service.RouteService;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Paths;

@Component
public class TourDetailsViewModel {
    private static final Logger logger = LogManager.getLogger(TourDetailsViewModel.class);
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
    @Getter
    private final ObjectProperty<Image> tourMap = new SimpleObjectProperty<>();

    private final TourServiceNew tourServiceNew;
    private final RouteService routeService;
    private TourModelNew tourModelNew;

    public TourDetailsViewModel(TourServiceNew tourServiceNew, RouteService routeService) {
        this.tourServiceNew = tourServiceNew;
        this.routeService = routeService;
    }

    public void setTour(TourModelNew tourModelNew) {
        if (tourModelNew == null) {
            resetValues();
            return;
        }

        this.tourModelNew = tourModelNew;
        retrieveValues(tourModelNew);
    }

    public void saveTour() {
        setValues();

        String sessionId = routeService.getRoute(tourModelNew);
        String imagePath = routeService.getStaticMap(sessionId);

        tourModelNew.setImagePath(imagePath);

        String path = Paths.get("").toAbsolutePath() + "\\" + tourModelNew.getImagePath();
        tourMap.set(new Image(path));

        tourServiceNew.updateTour(tourModelNew);
    }

    public void retrieveValues(TourModelNew tourModelNew) {
        name.set(tourModelNew.getName());
        description.set(tourModelNew.getDescription());
        from.set(tourModelNew.getFrom());
        to.set(tourModelNew.getTo());
        type.set(tourModelNew.getTransportType());
        distance.set(tourModelNew.getDistance());
        estimatedTime.set(tourModelNew.getEstimatedTime());
        imagePath.set(tourModelNew.getImagePath());

        if (tourModelNew.getImagePath() != null) {
            String path = Paths.get("").toAbsolutePath() + "\\" + tourModelNew.getImagePath();
            tourMap.set(new Image(path));
        } else {
            tourMap.set(null);
        }
    }

    public void resetValues() {
        name.set("");
        description.set("");
        from.set("");
        to.set("");
        type.set("CAR");
        distance.set("");
        estimatedTime.set("");
        imagePath.set("");
        tourMap.set(null);
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
