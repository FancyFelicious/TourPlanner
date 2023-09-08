package org.fancylynx.application.BL.service;

import org.fancylynx.application.BL.model.tour.TourModel;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;

import java.util.List;
import java.util.Map;

public interface ReportService {
    void generateTourReport(TourModel tourModel);

    void generateSummaryReport(Map<TourModel, List<TourLogModel>> tours);
}
