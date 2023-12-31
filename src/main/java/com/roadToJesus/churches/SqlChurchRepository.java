package com.roadToJesus.churches;

import com.roadToJesus.road.RoadRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SqlChurchRepository extends RoadRepository, ChurchRepository, JpaRepository<Church, Long> {

    @Query(value = "SELECT b.id AS destinationChurch, " +
            "ST_DistanceSphere(ST_Point(a.longitude, a.latitude), ST_Point(b.longitude, b.latitude)) AS distance " +
            "FROM churches a " +
            "CROSS JOIN churches b " +
            "WHERE a.id = :churchId AND a.id != b.id " +
            "ORDER BY distance",
            nativeQuery = true)
    List<Object[]> distancesBetweenChurchToOthers(@Param("churchId") Long churchId);

    @Query(value = "SELECT a.id AS destinationChurch, " +
            "ST_DistanceSphere(ST_Point(a.longitude, a.latitude), ST_Point(:longitude, :latitude)) AS distance " +
            "FROM churches a " +
            "ORDER BY distance",
            nativeQuery = true)
    List<Object[]> distancesBetweenPointToChurches(@Param("longitude") double longitude, @Param("latitude") double latitude);
}
