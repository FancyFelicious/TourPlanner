package org.fancylynx.application.DAL.repository;

import org.fancylynx.application.DAL.entity.TourLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourLogRepository extends JpaRepository<TourLog, Long> {

    // This is a Spring Data JPA feature. It allows us to define a method in the repository interface
    // and Spring will automatically generate the implementation for us
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    List<TourLog> findByTourId(long tourId);
}
