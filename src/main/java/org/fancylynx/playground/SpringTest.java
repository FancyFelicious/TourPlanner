package org.fancylynx.playground;

import jakarta.persistence.*;

@Entity(name = "spring_test")
//@Table(name = "spring_test333", uniqueConstraints = {
//        @UniqueConstraint(name = "spring_test_unique_name", columnNames = "testName2")
//})
public class SpringTest {

    @Id
    @SequenceGenerator(name = "spring_test_sequence", sequenceName = "spring_test_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spring_test_sequence")

    // 2do: add @Column for column name in db (best practice)
    @Column(name = "id", unique = true, updatable = false, nullable = false, columnDefinition = "BIGINT")
    private long id; // 2do: change to long / big serial? (not necessary but best practice flex, simulating huge db)

    @Column(name = "testName2", nullable = false, columnDefinition = "TEXT")
    private String name;
    private String description;

    public SpringTest() {
    }

    public SpringTest(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
