package org.fancylynx.playground.archive.serialization;

//public record Tour(String name,
//                   String description,
//                   String from,
//                   String to,
//                   String transportType,
//                   Double tourDistance,
//                   String estimatedTime,
//                   String routeInformation) {
//}

import lombok.Data;

@Data
public class Tour {
    private String name;
    private String description;
    private String from;
    private String to;
    private String transportType;
    private Double tourDistance;
    private String estimatedTime;
    private String routeInformation;
}
