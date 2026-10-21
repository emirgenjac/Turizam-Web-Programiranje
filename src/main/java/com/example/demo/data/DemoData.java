package com.example.demo.data;

import com.example.demo.model.Destination;
import com.example.demo.model.Tour;

import java.util.ArrayList;
import java.util.List;

public class DemoData {

    private static final List<Destination> destinations = new ArrayList<>();
    private static final List<Tour> tours = new ArrayList<>();

    static {
        Destination sarajevo = new Destination(1L, "Sarajevo", "Bosna i Hercegovina",
                "Glavni grad sa bogatom historijom.", 0, new ArrayList<>());
        Destination mostar = new Destination(2L, "Mostar", "Bosna i Hercegovina",
                "Stari most i Neretva.", 0, new ArrayList<>());
        Destination dubrovnik = new Destination(3L, "Dubrovnik", "Hrvatska",
                "Zidine i Stari grad.", 0, new ArrayList<>());

        Tour t1 = new Tour(1L, "Šetnja Baščaršijom", 1, 25.0, "Kulturna", "Sarajevo");
        Tour t2 = new Tour(2L, "Trebević žičara", 1, 40.0, "Avantura", "Sarajevo");
        Tour t3 = new Tour(3L, "Stari most i Stari grad", 1, 30.0, "Kulturna", "Mostar");
        Tour t4 = new Tour(4L, "Kravice vodopad", 1, 55.0, "Priroda", "Mostar");
        Tour t5 = new Tour(5L, "Obilazak zidina", 1, 35.0, "Kulturna", "Dubrovnik");
        Tour t6 = new Tour(6L, "Cavtat izlet", 2, 80.0, "Relaks", "Dubrovnik");

        sarajevo.getTours().add(t1);
        sarajevo.getTours().add(t2);
        mostar.getTours().add(t3);
        mostar.getTours().add(t4);
        dubrovnik.getTours().add(t5);
        dubrovnik.getTours().add(t6);

        destinations.add(sarajevo);
        destinations.add(mostar);
        destinations.add(dubrovnik);

        tours.add(t1);
        tours.add(t2);
        tours.add(t3);
        tours.add(t4);
        tours.add(t5);
        tours.add(t6);
    }

    public static List<Destination> getDestinations() {
        return destinations;
    }

    public static List<Tour> getTours() {
        return tours;
    }

    public static Destination findDestinationById(Long id) {
        for (Destination d : destinations) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public static List<Tour> findToursByDestination(String name) {
        List<Tour> result = new ArrayList<>();
        for (Tour t : tours) {
            if (t.getDestinationName().equalsIgnoreCase(name)) {
                result.add(t);
            }
        }
        return result;
    }
}