package com.roadToJesus.churches;

import com.roadToJesus.road.Road;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChurchController {
    private final ChurchService churchService;

    @GetMapping("/churches")
    public ResponseEntity<List<Church>> getAllChurches() {
        return churchService.getAllChurches();
    }

    @GetMapping("/roadtojesus/{id}")
    public ResponseEntity<List<Road>> roadToJesus(@PathVariable Long id){
        return churchService.roadToJesus(id);
    }
}
