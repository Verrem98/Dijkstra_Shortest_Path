package com.company;

import java.util.ArrayList;

public class Reis implements Comparable<Reis> {

    final ArrayList<Plaats> plaatsen;
    final Plaats startPlaats;
    final Plaats eindPlaats;
    final Stap stap;


    public Reis(ArrayList<Plaats> plaatsen, Plaats startPlaats, Plaats eindPlaats, Stap stap) {
        this.plaatsen = plaatsen;
        this.startPlaats = startPlaats;
        this.eindPlaats = eindPlaats;
        this.stap = stap;
    }

    public String shortestPath() {

        ArrayList<Plaats> nietBezocht = new ArrayList<>(plaatsen);
        ArrayList<Double> kleinsteAfstandVanStart = new ArrayList<>();
        ArrayList<Plaats> voorgaandePlaats = new ArrayList<>();


        for (int i = 0; i < plaatsen.size(); i++) {
            voorgaandePlaats.add(null);

        }


        for (Plaats plaats : plaatsen) {
            if (plaats == eindPlaats) {
                kleinsteAfstandVanStart.add(0.);
            } else {
                kleinsteAfstandVanStart.add(Double.MAX_VALUE);
            }
        }


        while (true) {


            Double lowestValue = Double.MAX_VALUE;
            Integer minIndex = null;


            for (int i = 0; i < nietBezocht.size(); i++) {

                if (nietBezocht.get(i) != null) {

                    if (kleinsteAfstandVanStart.get(i) < lowestValue) {
                        lowestValue = kleinsteAfstandVanStart.get(i);
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



                    if (viaPlaats == eindPlaats) {
                        return returnString.append(", ").append(kleinsteAfstandVanStart.get(plaatsen.indexOf(startPlaats))).append(stap.getEenheidsString()).toString();

                    }

                }

            }

            for (Plaats p : plaatsen.get(minIndex).getVerbindingen(stap.getName()).keySet()) {

                if (kleinsteAfstandVanStart.get(plaatsen.indexOf(p)) > (plaatsen.get(minIndex).getVerbindingen(stap.getName()).get(p) + kleinsteAfstandVanStart.get(minIndex))) {
                    kleinsteAfstandVanStart.set(plaatsen.indexOf(p), plaatsen.get(minIndex).getVerbindingen(stap.getName()).get(p) + kleinsteAfstandVanStart.get(minIndex));
                    voorgaandePlaats.set(plaatsen.indexOf(p), plaatsen.get(minIndex));
                }

            }

            nietBezocht.set(minIndex, null);


        }

    }

    @Override
    public int compareTo(Reis reis_2) {
        if (this.stap.getName().equals(reis_2.stap.getName())) {

            return Float.compare(Float.parseFloat(this.shortestPath().split(",")[1].split(" ")[1]), Float.parseFloat(reis_2.shortestPath().split(",")[1].split(" ")[1]));
        }else{
            throw new Error("Dit zijn 2 verschillende soorten reizen");
        }
    }
}
