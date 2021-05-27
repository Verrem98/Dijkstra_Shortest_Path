package com.company;

import java.util.HashMap;

public class Plaats {

    private String naam;

    private HashMap<Plaats, Double> vluchtVerbindingen = new HashMap<>();
    private HashMap<Plaats, Double> treinritVerbindingen = new HashMap<>();
    private HashMap<Plaats, Double> ritVerbindingen = new HashMap<>();


    public Plaats(String naam) {

        this.naam = naam;

    }


    public void setVerbinding(Plaats plaats, double waarde, Stap stap) {

        switch (stap.getName()) {
            case VLUCHT:
                this.vluchtVerbindingen.put(plaats, waarde);

                break;
            case TREINRIT:
                this.treinritVerbindingen.put(plaats, waarde);


                break;
            case RIT:
                this.ritVerbindingen.put(plaats, waarde);


                break;
        }


    }

    public HashMap<Plaats, Double> getVerbindingen(VerbindingType verbindingType) {

        switch (verbindingType) {
            case VLUCHT:
                return vluchtVerbindingen;

            case TREINRIT:
                return treinritVerbindingen;

            case RIT:
                return ritVerbindingen;
        }

        throw new IllegalArgumentException("geen geldig verbindingtype");
    }

    public HashMap<Plaats, Double> getVluchtVerbindingen() {
        return vluchtVerbindingen;
    }

    public HashMap<Plaats, Double> getTreinVerbindingen() {
        return treinritVerbindingen;
    }

    public HashMap<Plaats, Double> getWegVerbindingen() {
        return ritVerbindingen;
    }

    public String getNaam() {
        return naam;
    }
}
