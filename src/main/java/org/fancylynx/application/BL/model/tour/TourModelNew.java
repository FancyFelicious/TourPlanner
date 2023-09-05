package org.fancylynx.application.BL.model.tour;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
