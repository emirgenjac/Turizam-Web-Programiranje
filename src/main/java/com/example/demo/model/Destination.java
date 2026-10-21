package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination {
    private Long id;
    private String name;
    private String country;
    private String description;
    private int bookings;
    private List<Tour> tours = new ArrayList<>();
}