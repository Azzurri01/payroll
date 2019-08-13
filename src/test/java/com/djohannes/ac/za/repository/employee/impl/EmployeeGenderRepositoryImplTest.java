package com.djohannes.ac.za.repository.employee.impl;

import com.djohannes.ac.za.domain.employee.EmployeeGender;
import com.djohannes.ac.za.factory.employee.EmployeeGenderFactory;
import com.djohannes.ac.za.repository.employee.EmployeeGenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeGenderRepositoryImplTest {

    private EmployeeGenderRepository repository;
    private EmployeeGender employeeGender;

    private EmployeeGender getSavedEmployeeGender()
    {
        Set<EmployeeGender> savedPopulation = this.repository.getAll();
        return  savedPopulation.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = EmployeeGenderRepositoryImpl.getRepository();
        this.employeeGender = EmployeeGenderFactory.getEmployeeGender("123", "456");
    }

    @Test
    public void aGetRepository()
    {
        Assert.assertNotNull(repository);
    }

    @Test
    public void bCreate()
    {
        EmployeeGender createdEmployeeGender = this.repository.create(this.employeeGender);
        System.out.println("Create method called: Created employeeGender = " + this.employeeGender);
        eGetAll();
        Assert.assertSame(createdEmployeeGender, this.employeeGender);
    }

    @Test
    public void cRead()
    {
        EmployeeGender savedEmployeeGender = getSavedEmployeeGender();
        System.out.println("Read method call 1: Reading EmployeeGenderID = " + savedEmployeeGender.getGenId());
        EmployeeGender readEmployeeGender = this.repository.read(savedEmployeeGender.getGenId());
        System.out.println("Read method call 2: Reading read = " + savedEmployeeGender);
        eGetAll();
        Assert.assertSame(savedEmployeeGender, readEmployeeGender);
    }

    @Test
    public void dUpdate()
    {
        String newGenID = "789";

        EmployeeGender desc = new EmployeeGender.Builder().copy(getSavedEmployeeGender()).getGenId(newGenID).build();
        System.out.println("In update, about_to_updated = " + desc);

        EmployeeGender updated = this.repository.update(desc);
        System.out.println("In update, updated = " + updated);

        Assert.assertEquals(newGenID, updated.getGenId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<EmployeeGender> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }

    @Test
    public void fDelete()
    {
        EmployeeGender savedEmployeeGender = getSavedEmployeeGender();
        this.repository.delete(savedEmployeeGender.getGenId());
        eGetAll();
    }
}