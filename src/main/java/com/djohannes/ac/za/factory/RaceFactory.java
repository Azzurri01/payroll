package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Race;
import com.djohannes.ac.za.util.Misc;

public class RaceFactory
{
    public static Race getRace(String desc)
    {
        return new Race.Builder()
                .getId(Misc.generateId())
                .getRace(desc)
                .build();
    }
}
