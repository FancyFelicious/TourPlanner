package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.DAL.entity.Tour;

public interface RouteService {
    public String getRoute(TourModelNew tour);
    public String getStaticMap(String sessionId);
}
