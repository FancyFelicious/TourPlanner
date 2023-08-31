package org.fancylynx.application.BL.service;

import org.fancylynx.application.DAL.entity.Tour;

public interface RouteService {
    public String getRoute(Tour tour);
    public String getStaticMap(String sessionId);
}
