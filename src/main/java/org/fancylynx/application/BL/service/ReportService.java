package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.TourModelNew;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;

import java.util.List;
import java.util.Map;

public interface ReportService {
    void generateTourReport(TourModelNew tourModel);
    void generateSummaryReport(Map<TourModelNew, List<TourLogModel>> tours);
}
