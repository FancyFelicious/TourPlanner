package org.fancylynx.application.viewmodel;

import javafx.beans.property.*;
import javafx.scene.image.Image;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fancylynx.application.BL.model.tour.RouteModel;
import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.BL.service.RouteService;
import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.springframework.stereotype.Component;

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
    private TourModel tourModel;

    public TourDetailsViewModel(TourServiceNew tourServiceNew, RouteService routeService, TourLogService tourLogService) {
        this.tourServiceNew = tourServiceNew;
        this.routeService = routeService;
        this.tourLogService = tourLogService;
    }

    public void setTour(TourModel tourModel) {
        if (tourModel == null) {
            resetValues();
            return;
        }

        this.tourModel = tourModel;
        retrieveValues(tourModel);
        popularity.set(calculatePopularity(tourModel));
    }

    public void saveTour() {
        setValues();

        RouteModel route = routeService.getRoute(tourModel);
        String imagePath = routeService.getStaticMap(route.getSessionId());

        tourModel.setEstimatedTime(route.getTime());
        tourModel.setDistance(route.getDistance());
        tourModel.setImagePath(imagePath);

//        String path = Paths.get("").toAbsolutePath() + "\\" + tourModel.getImagePath();
//        tourMap.set(new Image(path));
        distance.set(route.getDistance());
        estimatedTime.set(route.getTime());

        tourServiceNew.updateTour(tourModel);

        logger.info("Saved tour with id=[{}]", tourModel.getTourId());
    }

    public void retrieveValues(TourModel tourModel) {
        name.set(tourModel.getName());
        description.set(tourModel.getDescription());
        from.set(tourModel.getFrom());
        to.set(tourModel.getTo());
        type.set(tourModel.getTransportType());
        estimatedTime.set(tourModel.getEstimatedTime());
        imagePath.set(tourModel.getImagePath());

        if (tourModel.getImagePath() != null) {
            String path = Paths.get("").toAbsolutePath() + "\\" + tourModel.getImagePath();
            tourMap.set(new Image(path));
        } else {
            tourMap.set(null);
        }

        if (tourModel.getDistance() != null) {
            distance.set(tourModel.getDistance());
        } else {
            distance.set(0);
        }
    }

    public String calculatePopularity(TourModel tourModel) {
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
        tourModel.setName(name.get());
        tourModel.setDescription(description.get());
        tourModel.setFrom(from.get());
        tourModel.setTo(to.get());
        tourModel.setTransportType(type.get());
        tourModel.setDistance(distance.get());
        tourModel.setEstimatedTime(estimatedTime.get());
        tourModel.setImagePath(imagePath.get());
    }
}
