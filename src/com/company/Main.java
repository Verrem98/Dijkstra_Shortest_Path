package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {


        Plaats london = new Plaats("London");
        Plaats amsterdam = new Plaats("Amsterdam");
        Plaats utrecht = new Plaats("Utrecht");
        Plaats brussel = new Plaats("Brussel");
        Plaats reykjavik = new Plaats("Reykjavik");

        // verbindingType: vlucht/treinrit/rit

        london.setVerbinding(amsterdam,63, "vlucht");
        london.setVerbinding(brussel,90, "vlucht");
        london.setVerbinding(reykjavik,83,"vlucht");
        london.setVerbinding(brussel,189, "treinrit");
        london.setVerbinding(amsterdam, 539, "rit");
        london.setVerbinding(utrecht, 507, "rit");
        london.setVerbinding(brussel, 373, "rit");

        amsterdam.setVerbinding(london, 63, "vlucht");
        amsterdam.setVerbinding(brussel, 119, "vlucht");
        amsterdam.setVerbinding(reykjavik, 133, "vlucht");
        amsterdam.setVerbinding(utrecht, 22, "treinrit");
        amsterdam.setVerbinding(brussel, 116, "treinrit");
        amsterdam.setVerbinding(utrecht, 45, "rit");
        amsterdam.setVerbinding(brussel, 202, "rit");
        amsterdam.setVerbinding(london, 539, "rit");

        utrecht.setVerbinding(amsterdam,22,"treinrit" );
        utrecht.setVerbinding(amsterdam,45,"rit" );
        utrecht.setVerbinding(amsterdam,22,"treinrit" );
        utrecht.setVerbinding(brussel,162,"treinrit" );
        utrecht.setVerbinding(brussel,170,"rit" );
        utrecht.setVerbinding(london,507,"rit" );

        brussel.setVerbinding(london, 90, "vlucht");
        brussel.setVerbinding(amsterdam, 119, "vlucht");
        brussel.setVerbinding(reykjavik, 279, "vlucht");
        brussel.setVerbinding(london, 189, "treinrit");
        brussel.setVerbinding(amsterdam, 116, "treinrit");
        brussel.setVerbinding(utrecht, 162, "treinrit");
        brussel.setVerbinding(london, 373, "rit");
        brussel.setVerbinding(utrecht, 170, "rit");
        brussel.setVerbinding(amsterdam, 202, "rit");

        reykjavik.setVerbinding(london,83,"vlucht");
        reykjavik.setVerbinding(amsterdam,133,"vlucht");
        reykjavik.setVerbinding(brussel,279,"vlucht");






    }
}
