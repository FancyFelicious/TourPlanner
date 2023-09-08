package org.fancylynx.application.viewmodel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fancylynx.application.BL.model.tour.TourModelNew;
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
    private final TourServiceNew tourService;
    private final TourLogService tourLogService;

    public SearchBarViewModel(TourOverviewViewModel tourOverviewViewModel, TourServiceNew tourService, TourLogService tourLogService) {
        this.tourOverviewViewModel = tourOverviewViewModel;
        this.tourService = tourService;
        this.tourLogService = tourLogService;
    }

    public void doSearch(String searchString) {
        searchString = searchString.toLowerCase();
        Map<TourModelNew, List<TourLogModel>> completeTours = new HashMap<>();
        List<TourModelNew> tours = tourService.getAllTours();

        for (TourModelNew tour : tours) {
            List<TourLogModel> tourLogs = tourLogService.getAllTourLogs(tour.getTourId());
            completeTours.put(tour, tourLogs);
        }

        List<TourModelNew> filteredTours = new ArrayList<>();
        // Go through map and check each tour and its tourlogs if any value contains the searchString

        for (Map.Entry<TourModelNew, List<TourLogModel>> entry : completeTours.entrySet()) {
            TourModelNew tour = entry.getKey();
            List<TourLogModel> tourLogs = entry.getValue();
            if (containsStringInFields(tour, searchString)) {
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
            tourOverviewViewModel.setTours(tours);
        }

        logger.info("Perform search with searchString=[{}]", searchString);
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


}
