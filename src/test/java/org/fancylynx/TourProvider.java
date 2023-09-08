package org.fancylynx;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class TourProvider {

    public static TourModelNew provideTour() {
        TourModelNew tourModelNew = new TourModelNew();
        tourModelNew.setTourId(1L);
        tourModelNew.setName("TestTour");
        tourModelNew.setDescription("TestDescription");
        tourModelNew.setFrom("TestFrom");
        tourModelNew.setTo("TestTo");
        tourModelNew.setTransportType("AUTO");
        tourModelNew.setDistance(100.0);
        tourModelNew.setEstimatedTime(100L);
        tourModelNew.setImagePath(null);

        return tourModelNew;
    }

    public static List<TourLogModel> provideTourLogs() {
        List<TourLogModel> tourLogModels = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            TourLogModel mockTourLog = Mockito.mock(TourLogModel.class);
            tourLogModels.add(mockTourLog);
        }

        return tourLogModels;
    }


}
