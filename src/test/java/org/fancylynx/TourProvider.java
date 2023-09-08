package org.fancylynx;

import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class TourProvider {

    public static TourModel provideTour() {
        TourModel tourModel = new TourModel();
        tourModel.setTourId(1L);
        tourModel.setName("TestTour");
        tourModel.setDescription("TestDescription");
        tourModel.setFrom("TestFrom");
        tourModel.setTo("TestTo");
        tourModel.setTransportType("AUTO");
        tourModel.setDistance(100.0);
        tourModel.setEstimatedTime(100L);
        tourModel.setImagePath(null);

        return tourModel;
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
