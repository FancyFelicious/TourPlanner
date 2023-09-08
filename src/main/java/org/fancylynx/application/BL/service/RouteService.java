package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.RouteModel;
import org.fancylynx.application.BL.model.tour.TourModel;

public interface RouteService {
    public RouteModel getRoute(TourModel tour);

    public String getStaticMap(String sessionId);
}
