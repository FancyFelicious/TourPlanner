package org.fancylynx.application.BL.model.tour;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RouteModel {
    private String sessionId;
    private Double distance;
    private long time;
}
