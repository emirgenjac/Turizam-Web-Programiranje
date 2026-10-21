package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
    private Long id;
    private String name;
    private int durationDays;
    private double price;
    private String type;
    private String destinationName;
}