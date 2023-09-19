package com.roadToJesus.churches;

import java.util.List;
import java.util.Optional;

public interface ChurchRepository{

    List<Church> findAll();
    Optional<Church> findById(Long id);
}
