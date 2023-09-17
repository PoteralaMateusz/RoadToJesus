package com.roadToJesus.churches;

import com.roadToJesus.road.Road;
import com.roadToJesus.road.RoadConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChurchService {
    private final ChurchRepository churchRepository;
    private final RoadConverter roadConverter;

    public ResponseEntity<List<Church>> getAllChurches() {
        return churchRepository.findAll().size() == 0 ?
                ResponseEntity
                        .status(404)
                        .build() :
                ResponseEntity
                        .status(200)
                        .body(churchRepository.findAll());
    }

    public ResponseEntity<List<Road>> roadToJesus(Long id) {
        if (churchRepository.findById(id).isEmpty()) {
            return ResponseEntity
                    .status(404)
                    .build();
        }
        return ResponseEntity.status(200)
                .body(churchRepository.calculateDistances(id)
                        .stream()
                        .map(roadConverter::convert)
                        .collect(Collectors.toList()));
    }
}
