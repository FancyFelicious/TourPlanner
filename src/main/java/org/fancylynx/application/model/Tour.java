package org.fancylynx.application.model;

public record Tour(String name,
                   String description,
                   String from,
                   String to,
                   String transportType,
                   Double tourDistance,
                   String estimatedTime,
                   String routeInformation) {
}
