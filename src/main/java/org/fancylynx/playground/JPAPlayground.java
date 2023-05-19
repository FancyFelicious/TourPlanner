package org.fancylynx.playground;

import jakarta.persistence.*;

@Entity(name = "spring_test")
@Table(name = "spring_test", uniqueConstraints = {
        @UniqueConstraint(name = "spring_test_unique_name", columnNames = "test_name2")
})
public class JPAPlayground {
    @Id
    @SequenceGenerator(name = "spring_test_sequence", sequenceName = "spring_test_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spring_test_sequence")
    @Column(name = "id", unique = true, updatable = false, nullable = false, columnDefinition = "BIGINT")
    private long id; // note: best practice to use long for id, not really necessary regarding the scope of this project

    @Column(name = "test_name2", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "test_name2", nullable = false, columnDefinition = "TEXT")
    private String description;

    public JPAPlayground() {
    }

    public JPAPlayground(long id, String name, String description) {
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
