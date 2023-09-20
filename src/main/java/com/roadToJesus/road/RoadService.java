package com.roadToJesus.road;

import com.roadToJesus.churches.ChurchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoadService {
    private final ChurchRepository churchRepository;
    private final RoadRepository roadRepository;
    private final RoadConverter roadConverter;

    public ResponseEntity<List<Road>> roadsBetweenChurchToOthers(Long id) {
        if (churchRepository.findById(id).isEmpty()) {
            return ResponseEntity
                    .status(404)
                    .build();
        }
        return ResponseEntity.status(200)
                .body(roadRepository.distancesBetweenChurchToOthers(id)
                        .stream()
                        .map(roadConverter::convert)
                        .collect(Collectors.toList()));
    }

    public ResponseEntity<List<Road>> roadsBetweenPointToChurches(double longitude, double latitude){
        return ResponseEntity.status(200)
                .body(roadRepository.distancesBetweenPointToChurches(longitude,latitude)
                        .stream()
                        .map(roadConverter::convert)
                        .collect(Collectors.toList()));
    }
}
