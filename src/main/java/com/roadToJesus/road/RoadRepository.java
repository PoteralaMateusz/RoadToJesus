package com.roadToJesus.road;

import java.util.List;

public interface RoadRepository {

    List<Object[]> calculateDistancesBetweenChurchToOthers(Long churchId);
}
