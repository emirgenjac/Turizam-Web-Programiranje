package com.example.demo.controller;

import com.example.demo.data.DemoData;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Destination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    @GetMapping("/")
    public String home() {
        return "redirect:/a";
    }

    @GetMapping("/a")
    public String listA(Model model) {
        model.addAttribute("destinations", DemoData.getDestinations());
        return "listA";
    }

    @GetMapping("/a/action/{id}")
    public String action(@PathVariable Long id, Model model) {
        Destination destination = DemoData.findDestinationById(id);
        if (destination != null) {
            destination.setBookings(destination.getBookings() + 1);
        }
        model.addAttribute("destination", destination);
        return "action";
    }

    @GetMapping("/b")
    public String listB(@RequestParam(required = false) String destinacija, Model model) {
        if (destinacija == null || destinacija.isBlank()) {
            model.addAttribute("tours", DemoData.getTours());
        } else {
            model.addAttribute("tours", DemoData.findToursByDestination(destinacija));
        }
        model.addAttribute("destinacija", destinacija);
        return "listB";
    }

}