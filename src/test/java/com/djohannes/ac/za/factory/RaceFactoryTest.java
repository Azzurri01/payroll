package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    @Test
    public void getRace()
    {
        Race race = RaceFactory.getRace("Coloured");
        Assert.assertEquals("Coloured", race.getRace());
    }
}