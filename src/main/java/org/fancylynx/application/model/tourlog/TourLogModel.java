package org.fancylynx.application.model.tourlog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 2do
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TourLogModel {
    private long tourLogId;
    private String name;
    private LocalDate date;
    private String comment;
    private String difficulty;
    private double totalTime;
    private int rating;
}
