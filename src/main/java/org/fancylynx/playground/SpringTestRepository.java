package org.fancylynx.playground;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringTestRepository extends JpaRepository<SpringTest, Long> {
//    SpringTest findByName(String name);
}
