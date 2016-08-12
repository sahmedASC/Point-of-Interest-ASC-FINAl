package com.bss.pointofinterest;

import java.util.ArrayList;
import java.util.List;

//This will keep track of the key pairs that is saved in the user data.
public class Keys {

    public final String FILENAME = "Locations";
    public final String DALLAS_BBQ = "Dallas BBQ";
    public final String MCDONALDS = "McDonalds";
    public List<String> RESTAURANTS = new ArrayList<>();

    public Keys(){
        RESTAURANTS.add(DALLAS_BBQ);
        RESTAURANTS.add(MCDONALDS);
    }
}
