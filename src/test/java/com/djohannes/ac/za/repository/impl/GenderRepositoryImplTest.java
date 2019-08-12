package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Gender;
import com.djohannes.ac.za.factory.GenderFactory;
import com.djohannes.ac.za.repository.GenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {

    private GenderRepository repository;
    private Gender gender;

    private Gender getSavedGender()
    {
        Set<Gender> savedPopulation = this.repository.getAll();
        return  savedPopulation.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = GenderRepositoryImpl.getRepository();
        this.gender = GenderFactory.getGender("Male");
    }

    @Test
    public void aGetRepository()
    {
        Assert.assertNotNull(repository);
    }

    @Test
    public void bCreate()
    {
        Gender createdGender = this.repository.create(this.gender);
        System.out.println("Create method called: Created gender = " + this.gender);
        eGetAll();
        Assert.assertSame(createdGender, this.gender);
    }

    @Test
    public void cRead()
    {
        Gender savedGender = getSavedGender();
        System.out.println("Read method call 1: Reading GenderID = " + savedGender.getId());
        Gender readGender = this.repository.read(savedGender.getId());
        System.out.println("Read method call 2: Reading read = " + savedGender);
        eGetAll();
        Assert.assertSame(savedGender, readGender);
    }

    @Test
    public void dUpdate()
    {
        String newDesc = "Female";

        Gender desc = new Gender.Builder().copy(getSavedGender()).getGender(newDesc).build();
        System.out.println("In update, about_to_updated = " + desc);

        Gender updated = this.repository.update(desc);
        System.out.println("In update, updated = " + updated);

        Assert.assertEquals(newDesc, updated.getGender());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Gender> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }

    @Test
    public void fDelete()
    {
        Gender savedGender = getSavedGender();
        this.repository.delete(savedGender.getId());
        eGetAll();
    }
}