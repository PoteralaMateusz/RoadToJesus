package com.roadToJesus.road;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/road")
public class RoadController {
    private final RoadService roadService;

    @GetMapping("/church/{id}")
    public ResponseEntity<List<Road>> roadsBetweenChurchToOthers(@PathVariable Long id){
        return roadService.roadsBetweenChurchToOthers(id);
    }
}
