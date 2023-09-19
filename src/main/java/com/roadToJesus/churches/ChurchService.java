package com.roadToJesus.churches;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChurchService {
    private final ChurchRepository churchRepository;

    public ResponseEntity<List<Church>> getAllChurches() {
        return churchRepository.findAll().size() == 0 ?
                ResponseEntity
                        .status(404)
                        .build() :
                ResponseEntity
                        .status(200)
                        .body(churchRepository.findAll());
    }

    public ResponseEntity<Church> getChurchByID(Long id) {
        return churchRepository.findById(id)
                .map(church ->
                        ResponseEntity
                                .status(200)
                                .body(church))
                .orElse(ResponseEntity
                        .status(404)
                        .build());
    }

}
