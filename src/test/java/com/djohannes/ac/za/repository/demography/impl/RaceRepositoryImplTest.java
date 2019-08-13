package com.djohannes.ac.za.repository.demography.impl;

import com.djohannes.ac.za.domain.demography.Race;
import com.djohannes.ac.za.factory.demography.RaceFactory;
import com.djohannes.ac.za.repository.demography.RaceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceRepositoryImplTest {

    private RaceRepository repository;
    private Race race;

    private Race getSavedRace()
    {
        Set<Race> savedPopulation = this.repository.getAll();
        return  savedPopulation.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = RaceRepositoryImpl.getRepository();
        this.race = RaceFactory.getRace("Coloured");
    }

    @Test
    public void aGetRepository()
    {
        Assert.assertNotNull(repository);
    }

    @Test
    public void bCreate()
    {
        Race createdRace = this.repository.create(this.race);
        System.out.println("Create method called: Created race = " + this.race);
        eGetAll();
        Assert.assertSame(createdRace, this.race);
    }

    @Test
    public void cRead()
    {
        Race savedRace = getSavedRace();
        System.out.println("Read method call 1: Reading RaceID = " + savedRace.getId());
        Race readRace = this.repository.read(savedRace.getId());
        System.out.println("Read method call 2: Reading read = " + savedRace);
        eGetAll();
        Assert.assertSame(savedRace, readRace);
    }

    @Test
    public void dUpdate()
    {
        String newDesc = "Black";

        Race desc = new Race.Builder().copy(getSavedRace()).getRace(newDesc).build();
        System.out.println("In update, about_to_updated = " + desc);

        Race updated = this.repository.update(desc);
        System.out.println("In update, updated = " + updated);

        Assert.assertEquals(newDesc, updated.getRace());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Race> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }

    @Test
    public void fDelete()
    {
        Race savedRace = getSavedRace();
        this.repository.delete(savedRace.getId());
        eGetAll();
    }
}