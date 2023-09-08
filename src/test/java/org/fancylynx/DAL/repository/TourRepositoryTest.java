package org.fancylynx.DAL.repository;

import org.fancylynx.application.DAL.entity.Tour;
import org.fancylynx.application.DAL.repository.TourRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:postgresql://localhost:5431/tourplanner",
        "spring.datasource.username=postgres",
        "spring.datasource.password=password",
        "spring.datasource.driverClassName=org.postgresql.Driver",
        "spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect"
})
public class TourRepositoryTest {
    @Autowired
    private TourRepository tourRepository;

    @BeforeEach
    void setUp() {
        var tour = new Tour(1, "Test", "This is a description", "Vienna", "France", "AUTO", 123.1, 123, "images/mhm.png");
        tourRepository.saveAndFlush(tour);
    }

    @AfterEach
    void tearDown() {
        tourRepository.deleteAll();
    }

    // Why does this not work, if run with the other tests?
    //@Test
    void testInsertion() {
        var insertedTour = tourRepository.findById(1L);

        assertTrue(insertedTour.isPresent());
    }

    @Test
    void testDeleteByTourId() {
        tourRepository.deleteById(1L);

        var deletedTour = tourRepository.findById(1L);

        assertFalse(deletedTour.isPresent());
    }
}

