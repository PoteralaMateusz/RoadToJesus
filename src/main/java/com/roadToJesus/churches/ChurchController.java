package com.roadToJesus.churches;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/churches")
public class ChurchController {
    private final ChurchService churchService;

    @GetMapping("/all")
    public ResponseEntity<List<Church>> getAllChurches() {
        return churchService.getAllChurches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Church> getChurchByID(@PathVariable Long id) {
        return churchService.getChurchByID(id);
    }
}
