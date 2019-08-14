package com.djohannes.ac.za.service.demography.impl;

import com.djohannes.ac.za.domain.demography.Race;
import com.djohannes.ac.za.factory.demography.RaceFactory;
import com.djohannes.ac.za.repository.demography.RaceRepository;
import com.djohannes.ac.za.repository.demography.impl.RaceRepositoryImpl;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceServiceImplTest {


    private RaceRepository repository;
    private Race race;

    private Race getSavedRace(){
        Set<Race> savedRace = this.repository.getAll();
        return savedRace.iterator().next();
    }



    @Before
    public void setUp() throws Exception {
        this.repository = RaceRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        Set<Race>races = this.repository.getAll();
        System.out.println("In getall, all: " + races);
        Assert.assertEquals(2,this.repository.getAll().size());
    }

    @Test
    public void a_create() {
        Race race = RaceFactory.getRace("coloured");
        Race newGen = this.repository.create(race);
        System.out.println(newGen);

        Assert.assertEquals(1, this.repository.getAll().size());
        Assert.assertEquals("coloured", newGen.getRace());
        Assert.assertNotNull(newGen.getId());
    }

    @Test
    public void c_update() {
        Race race = RaceFactory.getRace("black");

        repository.create(race);
        Race inRepo = repository.read(race.getId());

        repository.update(race);
        System.out.println(race.getRace() + " " + inRepo.getRace());
        Assert.assertEquals(race.getRace(), inRepo.getRace());
    }

    @Test
    public void e_delete() {
        Race saved = getSavedRace();
        this.repository.delete(saved.getId());
        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void b_read() {
        Race savedRace = getSavedRace();
        Race read = this.repository.read(savedRace.getId());
        System.out.println("In read: " + read);
        Assert.assertSame(read,savedRace);
    }
}