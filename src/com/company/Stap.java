package com.company;

public class Stap {
    private String eenheidsString;
    private VerbindingType name;

    public Stap(String eenheidsString, VerbindingType name) {
        this.eenheidsString = eenheidsString;
        this.name = name;
    }

    public String getEenheidsString() {
        return eenheidsString;
    }

    public void setEenheidsString(String eenheidsString) {
        this.eenheidsString = eenheidsString;
    }

    public VerbindingType getName() {
        return name;
    }

    public void setName(VerbindingType name) {
        this.name = name;
    }
}
