package com.roadToJesus.road;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

@Service
public class RoadConverter {
    public Road convert(Object[] source) {
        Long destinationChurch = Long.valueOf((Integer)source[0]);
        Double distance = (Double) source[1];
        return new Road(destinationChurch, distance);
    }
}
