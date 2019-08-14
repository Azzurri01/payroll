package com.djohannes.ac.za.factory.demography;

import com.djohannes.ac.za.domain.demography.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    @Test
    public void getRace()
    {
        Race race = RaceFactory.getRace("Coloured");
        Assert.assertNotNull(race.getId());
        Assert.assertEquals("Coloured", race.getRace());
    }
}