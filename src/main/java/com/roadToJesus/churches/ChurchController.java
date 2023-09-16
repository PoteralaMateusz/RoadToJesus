package com.roadToJesus.churches;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChurchController {
    private final ChurchRepository churchRepository;

    @GetMapping("/churches")
    public List<Church> getAllChurches() {
        return churchRepository.findAll();
    }
}
