package org.fancylynx.application.viewmodel;

import javafx.beans.property.*;
import javafx.scene.image.Image;
import lombok.Getter;
import org.fancylynx.application.BL.model.tour.RouteModel;
import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.service.RouteService;
import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
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
    private final DoubleProperty distance = new SimpleDoubleProperty();
    @Getter
    private final LongProperty estimatedTime = new SimpleLongProperty();
    @Getter
    private final StringProperty imagePath = new SimpleStringProperty();
    @Getter
    private final ObjectProperty<Image> tourMap = new SimpleObjectProperty<>();
    @Getter
    private final StringProperty popularity = new SimpleStringProperty();
    @Getter
    private final StringProperty childFriendly = new SimpleStringProperty();

    private final TourServiceNew tourServiceNew;
    private final RouteService routeService;
    private final TourLogService tourLogService;
    private TourModelNew tourModelNew;

    public TourDetailsViewModel(TourServiceNew tourServiceNew, RouteService routeService, TourLogService tourLogService) {
        this.tourServiceNew = tourServiceNew;
        this.routeService = routeService;
        this.tourLogService = tourLogService;
    }

    public void setTour(TourModelNew tourModelNew) {
        if (tourModelNew == null) {
            resetValues();
            return;
        }

        this.tourModelNew = tourModelNew;
        retrieveValues(tourModelNew);
        popularity.set(calculatePopularity(tourModelNew));
    }

    public void saveTour() {
        if (!validInput()) {
            return;
        }

        setValues();

        RouteModel route = routeService.getRoute(tourModelNew);
        String imagePath = routeService.getStaticMap(route.getSessionId());

        tourModelNew.setEstimatedTime(route.getTime());
        tourModelNew.setDistance(route.getDistance());
        tourModelNew.setImagePath(imagePath);

        String path = System.getProperty("user.dir") + File.separator + tourModelNew.getImagePath();

        tourMap.set(new Image(path));
        distance.set(route.getDistance());
        estimatedTime.set(route.getTime());

        tourServiceNew.updateTour(tourModelNew);

        logger.info("Saved tour with id=[{}]", tourModelNew.getTourId());
    }

    public void retrieveValues(TourModelNew tourModelNew) {
        name.set(tourModelNew.getName());
        description.set(tourModelNew.getDescription());
        from.set(tourModelNew.getFrom());
        to.set(tourModelNew.getTo());
        type.set(tourModelNew.getTransportType());
        estimatedTime.set(tourModelNew.getEstimatedTime());
        imagePath.set(tourModelNew.getImagePath());

        if (tourModelNew.getImagePath() != null) {
            String path = Paths.get("").toAbsolutePath() + "\\" + tourModelNew.getImagePath();
            tourMap.set(new Image(path));
        } else {
            tourMap.set(null);
        }

        if (tourModelNew.getDistance() != null) {
            distance.set(tourModelNew.getDistance());
        } else {
            distance.set(0);
        }
    }

    public String calculatePopularity(TourModelNew tourModel) {
        int tourLogs = tourLogService.getAllTourLogs(tourModel.getTourId()).size();

        if (tourLogs > 15) {
            return "Very popular: " + tourLogs + " logs";
        } else if (tourLogs > 10) {
            return "Popular: " + tourLogs + " logs";
        } else if (tourLogs > 5) {
            return "Somewhat popular: " + tourLogs + " logs";
        } else {
            return "Not popular: " + tourLogs + " logs";
        }
    }

    public void resetValues() {
        name.set("");
        description.set("");
        from.set("");
        to.set("");
        type.set("AUTO");
        distance.set(0);
        estimatedTime.set(0);
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

    public Boolean validInput() {
        return true;
    }
}
