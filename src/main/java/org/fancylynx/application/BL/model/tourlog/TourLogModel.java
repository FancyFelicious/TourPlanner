package org.fancylynx.application.BL.model.tourlog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TourLogModel {
    private long tourLogId;
    private LocalDate date;
    private String comment;
    private int difficulty;
    private double totalTime;
    private int rating;
}
