package com.roadToJesus.churches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChurchRepository extends JpaRepository<Church, Long> {
}
