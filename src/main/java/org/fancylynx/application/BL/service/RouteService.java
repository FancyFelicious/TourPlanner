package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.RouteModel;
import org.fancylynx.application.BL.model.tour.TourModel;

public interface RouteService {
    RouteModel getRoute(TourModel tour);

    String getStaticMap(String sessionId);
}
