package org.fancylynx.application.repository;

import org.fancylynx.application.entity.TourLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourLogRepository extends JpaRepository<TourLog, Long> {
}
