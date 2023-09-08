package org.fancylynx.application.viewmodel;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.fancylynx.application.BL.service.TourLogService;
import org.fancylynx.application.BL.service.TourServiceNew;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SearchBarViewModel {
    private static final Logger logger = LogManager.getLogger(SearchBarViewModel.class);
    private final TourOverviewViewModel tourOverviewViewModel;
    private final TourDetailsViewModel tourDetailsViewModel;
    private final TourServiceNew tourService;
    private final TourLogService tourLogService;
    @Getter
    private List<TourModel> filteredTours;

    public SearchBarViewModel(TourOverviewViewModel tourOverviewViewModel, TourDetailsViewModel tourDetailsViewModel, TourServiceNew tourService, TourLogService tourLogService) {
        this.tourOverviewViewModel = tourOverviewViewModel;
        this.tourDetailsViewModel = tourDetailsViewModel;
        this.tourService = tourService;
        this.tourLogService = tourLogService;
    }

    public static boolean containsStringInFields(Object object, String searchString) {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object fieldValue = field.get(object);

                if (fieldValue != null) {
                    if (fieldValue instanceof String value) {
                        if (value.toLowerCase().contains(searchString.toLowerCase())) {
                            return true;
                        }
                    } else if (fieldValue instanceof Number) {
                        String valueStr = fieldValue.toString().toLowerCase();
                        if (valueStr.contains(searchString.toLowerCase())) {
                            return true;
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                logger.error("Error while accessing field=[{}] of object=[{}]", field.getName(), object, e);
            }
        }


        return false;
    }

    public void doSearch(String searchString) {
        String popularity;
        String childFriendly;

        searchString = searchString.toLowerCase();
        Map<TourModel, List<TourLogModel>> completeTours = new HashMap<>();
        List<TourModel> tours = tourService.getAllTours();
        tourOverviewViewModel.setTours(tours);

        if (searchString.isEmpty()) {
            return;
        }

        for (TourModel tour : tours) {
            List<TourLogModel> tourLogs = tourLogService.getAllTourLogs(tour.getTourId());
            completeTours.put(tour, tourLogs);
        }

        filteredTours = new ArrayList<>();

        for (Map.Entry<TourModel, List<TourLogModel>> entry : completeTours.entrySet()) {
            TourModel tour = entry.getKey();
            popularity = tourDetailsViewModel.calculatePopularity(tour).toLowerCase();
            //childFriendly = tourDetailsViewModel.calculateChildFriendly();

            List<TourLogModel> tourLogs = entry.getValue();

            if (containsStringInFields(tour, searchString) || popularity.contains(searchString)) {
                filteredTours.add(tour);
            } else {
                for (TourLogModel tourLog : tourLogs) {
                    if (containsStringInFields(tourLog, searchString)) {
                        filteredTours.add(tour);
                        break;
                    }
                }
            }
        }

        if (!filteredTours.isEmpty()) {
            tourOverviewViewModel.setTours(filteredTours);
        } else {
            tourOverviewViewModel.getObservableTours().clear();
        }

        logger.info("Perform search with searchString=[{}]", searchString);
    }


}
