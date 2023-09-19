package com.roadToJesus.road;

import org.springframework.stereotype.Service;

@Service
public class RoadConverter {
    public Road convert(Object[] source) {
        String start = (String) source[0];
        String destination = (String) source[1];
        Double distance = (Double) source[2];
        return new Road(start, destination, distance);
    }
}
