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

    @GetMapping("/point/")
    public ResponseEntity<List<Road>> roadsBetweenPointToChurches(@RequestBody LocationPoint point) {
        return roadService.roadsBetweenPointToChurches(point.longitude(), point.latitude());
    }
}
