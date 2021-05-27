package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Reis implements Comparable<Reis> {

    private ArrayList<Plaats> plaatsen;
    private Plaats startPlaats;
    private Plaats eindPlaats;
    private Stap stap;


    public Reis(ArrayList<Plaats> plaatsen, Plaats startPlaats, Plaats eindPlaats, Stap stap) {
        this.plaatsen = plaatsen;
        this.startPlaats = startPlaats;
        this.eindPlaats = eindPlaats;
        this.stap = stap;
    }

    public String shortestPath() {

        ArrayList<Plaats> unvisited = new ArrayList<>(plaatsen);
        ArrayList<Double> shortestDisFromStart = new ArrayList<>();
        ArrayList<Plaats> voorgaandePlaats = new ArrayList<>();


        for (int i = 0; i < plaatsen.size(); i++) {
            voorgaandePlaats.add(null);

        }


        for (Plaats plaats : plaatsen) {
            if (plaats == eindPlaats) {
                shortestDisFromStart.add(0.);
            } else {
                shortestDisFromStart.add(Double.MAX_VALUE);
            }
        }


        while (true) {


            Double lowestValue = Double.MAX_VALUE;
            Integer minIndex = null;


            for (int i = 0; i < unvisited.size(); i++) {

                if (unvisited.get(i) != null) {

                    if (shortestDisFromStart.get(i) < lowestValue) {
                        lowestValue = shortestDisFromStart.get(i);
                        minIndex = i;

                    }

                }

            }

            if (minIndex == null) {

                StringBuilder returnString = new StringBuilder();

                returnString.append("Optimale route: \n");

                returnString.append(startPlaats.getNaam());

                Plaats viaPlaats = startPlaats;

                while (true) {

                    viaPlaats = voorgaandePlaats.get(plaatsen.indexOf(viaPlaats));


                    if (viaPlaats == null) {
                        throw new IllegalArgumentException("Deze steden zijn niet met elkaar verbonden via " + stap.getName().toString().toLowerCase());
                    }
                    returnString.append(" --> ").append(viaPlaats.getNaam());
                    ;


                    if (viaPlaats == eindPlaats) {
                        return returnString.append(", ").append(shortestDisFromStart.get(plaatsen.indexOf(startPlaats))).append(stap.getEenheidsString()).toString();

                    }

                }

            }

            for (Plaats p : plaatsen.get(minIndex).getVerbindingen(stap.getName()).keySet()) {

                if (shortestDisFromStart.get(plaatsen.indexOf(p)) > (plaatsen.get(minIndex).getVerbindingen(stap.getName()).get(p) + shortestDisFromStart.get(minIndex))) {
                    shortestDisFromStart.set(plaatsen.indexOf(p), plaatsen.get(minIndex).getVerbindingen(stap.getName()).get(p) + shortestDisFromStart.get(minIndex));
                    voorgaandePlaats.set(plaatsen.indexOf(p), plaatsen.get(minIndex));
                }

            }

            unvisited.set(minIndex, null);


        }

    }

    @Override
    public int compareTo(Reis reis_2) {
        if (this.stap.getName().equals(reis_2.stap.getName())) {

            if (Float.parseFloat(this.shortestPath().split(",")[1].split(" ")[1]) > Float.parseFloat(reis_2.shortestPath().split(",")[1].split(" ")[1])) {
                return 1;

            } else if (Float.parseFloat(this.shortestPath().split(",")[1].split(" ")[1]) < Float.parseFloat(reis_2.shortestPath().split(",")[1].split(" ")[1])) {
                return -1;

            } else {
                return 0;
            }
        }else{
            throw new Error("Dit zijn 2 verschillende soorten reizen");
        }
    }
}
