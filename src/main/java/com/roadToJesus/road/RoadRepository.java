package com.roadToJesus.road;

import java.util.List;

public interface RoadRepository {

    List<Object[]> distancesBetweenChurchToOthers(Long churchId);

    List<Object[]> distancesBetweenPointToChurches(double longitude, double latitude);
}
