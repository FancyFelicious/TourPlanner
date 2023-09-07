package org.fancylynx.application.DAL.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// 2do
//, uniqueConstraints = {
//        @UniqueConstraint(name = "tour_unique_name", columnNames = "test_name2")
//})
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tour")
@Table(name = "tour")
@Data
@Repository
public class Tour {
    @Id
    @SequenceGenerator(name = "tour_sequence", sequenceName = "tour_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tour_sequence")
    @Column(name = "id", unique = true, updatable = false, nullable = false, columnDefinition = "BIGINT")
    private long id; // note: best practice to use long for id, not really necessary regarding the scope of this project

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "transport_type")
    private String transportType;

    @Column(name = "distance")
    private Double distance; // 2do: float?

    @Column(name = "estimated_time")
    private long estimatedTime; // 2do: time?

    @Column(name = "image_path")
    private String imagePath;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<TourLog> tourLogs = new ArrayList<>();

    public Tour(long id, String name, String description, String origin, String destination, String transportType, Double distance, long estimatedTime, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.origin = origin;
        this.destination = destination;
        this.transportType = transportType;
        this.distance = distance;
        this.estimatedTime = estimatedTime;
        this.imagePath = imagePath;
    }
}


