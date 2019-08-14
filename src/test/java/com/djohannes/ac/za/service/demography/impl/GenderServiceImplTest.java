package com.djohannes.ac.za.service.demography.impl;

import com.djohannes.ac.za.domain.demography.Gender;
import com.djohannes.ac.za.factory.demography.GenderFactory;
import com.djohannes.ac.za.repository.demography.GenderRepository;
import com.djohannes.ac.za.repository.demography.impl.GenderRepositoryImpl;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderServiceImplTest {


    private GenderRepository repository;
    private Gender gender;

    private Gender getSavedGender(){
        Set<Gender> savedGender = this.repository.getAll();
        return savedGender.iterator().next();
    }



    @Before
    public void setUp() throws Exception {
        this.repository = GenderRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        Set<Gender>genders = this.repository.getAll();
        System.out.println("In getall, all: " + genders);
        Assert.assertEquals(2,this.repository.getAll().size());
    }

    @Test
    public void a_create() {
        Gender gender = GenderFactory.getGender("male");
        Gender newGen = this.repository.create(gender);
        System.out.println(newGen);

        Assert.assertEquals(1, this.repository.getAll().size());
        Assert.assertEquals("male", newGen.getGender());
        Assert.assertNotNull(newGen.getId());
    }

    @Test
    public void c_update() {
        Gender gender = GenderFactory.getGender("female");

        repository.create(gender);
        Gender inRepo = repository.read(gender.getId());

        repository.update(gender);
        System.out.println(gender.getGender() + " " + inRepo.getGender());
        Assert.assertEquals(gender.getGender(), inRepo.getGender());
    }

    @Test
    public void e_delete() {
        Gender saved = getSavedGender();
        this.repository.delete(saved.getId());
        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void b_read() {
        Gender savedGender = getSavedGender();
        Gender read = this.repository.read(savedGender.getId());
        System.out.println("In read: " + read);

        Assert.assertSame(read,savedGender);
    }
}