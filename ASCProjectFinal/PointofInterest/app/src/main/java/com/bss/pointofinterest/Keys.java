package com.bss.pointofinterest;

import java.util.ArrayList;
import java.util.List;

//This will keep track of the key pairs that is saved in the user data.
public class Keys {

    public final String FILENAME = "Locations";
    public final String DALLAS_BBQ = "Dallas BBQ";
    public final String MCDONALDS = "McDonald's";
    public final String MACYS="All Star Comics";
    public final String GAMESTOP="GameStop";
    public final String COMIC_CENTRAL = "Comic Central";
    public final String MID_COMICS = "Midtown Comics";
    public List<String> LOCATIONS = new ArrayList<>();
    public Keys(){
        LOCATIONS.add(DALLAS_BBQ);
        LOCATIONS.add(MCDONALDS);
        LOCATIONS.add(MACYS);
        LOCATIONS.add(GAMESTOP);
        LOCATIONS.add(COMIC_CENTRAL);
        LOCATIONS.add(MID_COMICS);
    }
}
