package com.djohannes.ac.za.factory.demography;

import com.djohannes.ac.za.domain.demography.Gender;
import com.djohannes.ac.za.util.Misc;

public class GenderFactory
{
    public static Gender getGender(String desc)
    {
        return new Gender.Builder()
                .getId(Misc.generateId())
                .getGender(desc)
                .build();
    }
}
