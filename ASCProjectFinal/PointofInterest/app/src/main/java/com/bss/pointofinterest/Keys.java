package com.bss.pointofinterest;

import java.util.ArrayList;
import java.util.List;

//This will keep track of the key pairs that is saved in the user data.
public class Keys {

    public final String FILENAME = "Locations";
    public final String DALLAS_BBQ = "Dallas BBQ";
    public final String MCDONALDS = "McDonald's";
    public final String MACYS="Macy's";
    public final String GAMESTOP="GameStop";
    public List<String> LOCATIONS = new ArrayList<>();
    public Keys(){
        LOCATIONS.add(DALLAS_BBQ);
        LOCATIONS.add(MCDONALDS);
        LOCATIONS.add(MACYS);
        LOCATIONS.add(GAMESTOP);
        
    }
}
