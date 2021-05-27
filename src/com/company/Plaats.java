package com.company;

import java.util.HashMap;

public class Plaats {

    private String naam;

    private HashMap<Plaats, Double> vluchtVerbindingen = new HashMap<>();
    private HashMap<Plaats, Double> treinritVerbindingen = new HashMap<>();
    private HashMap<Plaats, Double> ritVerbindingen = new HashMap<>();



    public Plaats(String naam){

        this.naam = naam;

    }


    public void setVerbinding(Plaats plaats, double waarde, String verbindingType){

        if(verbindingType.equals("vlucht")){
            this.vluchtVerbindingen.put(plaats,waarde);

        }
        if(verbindingType.equals("treinrit")){
            this.treinritVerbindingen.put(plaats,waarde);


        }
        if(verbindingType.equals("rit")){
            this.ritVerbindingen.put(plaats,waarde);


        }


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
}
