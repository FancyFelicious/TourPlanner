package org.fancylynx.application.BL.model.tour;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.fancylynx.application.BL.model.tourlog.TourLogModel;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TourModelNew {
    private long tourId;
    private String name;
    private String description;
    private String from;
    private String to;
    private String transportType;
    private Double distance;
    private long estimatedTime;
    private String imagePath;

    private List<TourLogModel> tourLogs;

    public TourModelNew(long tourId, String name, String description, String from, String to, String transportType, Double distance, long estimatedTime, String imagePath) {
        this.tourId = tourId;
        this.name = name;
        this.description = description;
        this.from = from;
        this.to = to;
        this.transportType = transportType;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
        this.imagePath = imagePath;
    }
}
