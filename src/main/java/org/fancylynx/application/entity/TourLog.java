package org.fancylynx.application.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name="tour_log")
@Table(name="tour_log")
@Data
@Repository
public class TourLog {
    @Id
    @GeneratedValue
    @Column(name="id", unique=true, updatable=false, nullable=false, columnDefinition="BIGINT")
    private long id;

    @Column(name="name", unique=true, nullable=false, columnDefinition="TEXT")
    private String name;

    @Column(name="date", columnDefinition="DATETIME")
    private LocalDateTime date;

    @Column(name="comment", columnDefinition="TEXT")
    private String comment;

    @Column(name="difficulty", columnDefinition="INT")
    private int difficulty;

    @Column(name="total_time", columnDefinition="TIME")
    private LocalTime totalTime;

    @Column(name="rating", columnDefinition="INT")
    private int rating;

    @ManyToOne
    @JoinColumn(name="tour_id", referencedColumnName="id", nullable=false)
    private Tour tour;

}
