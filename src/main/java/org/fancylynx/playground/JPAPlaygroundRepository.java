package org.fancylynx.playground;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAPlaygroundRepository extends JpaRepository<JPAPlayground, Long> {
//    SpringTest findByName(String name);
}
