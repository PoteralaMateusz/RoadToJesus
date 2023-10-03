package com.roadToJesus.road;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/road")
public class RoadController {
    private final RoadService roadService;

    @GetMapping("/church/{id}")
    public ResponseEntity<List<Road>> roadsBetweenChurchToOthers(@PathVariable Long id) {
        return roadService.roadsBetweenChurchToOthers(id);
    }

    @GetMapping("/point/{longitude}/{latitude}")
    public ResponseEntity<List<Road>> roadsBetweenPointToChurches(@PathVariable double longitude, @PathVariable double latitude) {
        return roadService.roadsBetweenPointToChurches(longitude, latitude);
    }
}
