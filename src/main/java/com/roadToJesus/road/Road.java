package com.roadToJesus.road;

import com.roadToJesus.churches.Church;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Road {
    private Church destinationChurch;
    private Double distance;
}
