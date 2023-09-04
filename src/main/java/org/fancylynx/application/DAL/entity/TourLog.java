package org.fancylynx.application.DAL.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(name="tour_log")
@Table(name="tour_log")
@Data
@Repository
public class TourLog implements Serializable {

    public TourLog(Tour tour) {
        this.tour = tour;
    }

    @Id
    @GeneratedValue
    @Column(name="id", unique=true, updatable=false, nullable=false, columnDefinition="BIGINT")
    private long id;

    @Column(name="date", columnDefinition="DATE")
    private LocalDate date;

    @Column(name="comment", columnDefinition="TEXT")
    private String comment;

    @Column(name="difficulty", columnDefinition="TEXT")
    private String difficulty;

    @Column(name="total_time", columnDefinition="FLOAT")
    private double totalTime;

    @Column(name="rating", columnDefinition="INT")
    private int rating;

    @ManyToOne
    @JoinColumn(name="tour_id", referencedColumnName="id", nullable=false)
    private Tour tour;

    public TourLog() {

    }
}
