package com.djohannes.ac.za.repository.employee.impl;

import com.djohannes.ac.za.domain.employee.EmployeeRace;
import com.djohannes.ac.za.factory.employee.EmployeeRaceFactory;
import com.djohannes.ac.za.repository.employee.EmployeeRaceRepository;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRaceRepositoryImplTest {

    private EmployeeRaceRepository repository;
    private EmployeeRace employeeRace;

    private EmployeeRace getSavedEmployeeRace()
    {
        Set<EmployeeRace> savedPopulation = this.repository.getAll();
        return  savedPopulation.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = EmployeeRaceRepositoryImpl.getRepository();
        this.employeeRace = EmployeeRaceFactory.getEmployeeRace("123", "456");
    }

    @Test
    public void aGetRepository()
    {
        Assert.assertNotNull(repository);
    }

    @Test
    public void bCreate()
    {
        EmployeeRace createdEmployeeRace = this.repository.create(this.employeeRace);
        System.out.println("Create method called: Created employeeRace = " + this.employeeRace);
        eGetAll();
        Assert.assertSame(createdEmployeeRace, this.employeeRace);
    }

    @Test
    public void cRead()
    {
        EmployeeRace savedEmployeeRace = getSavedEmployeeRace();
        System.out.println("Read method call 1: Reading EmployeeRaceID = " + savedEmployeeRace.getRaceId());
        EmployeeRace readEmployeeRace = this.repository.read(savedEmployeeRace.getRaceId());
        System.out.println("Read method call 2: Reading read = " + savedEmployeeRace);
        eGetAll();
        Assert.assertSame(savedEmployeeRace, readEmployeeRace);
    }

    @Ignore
    @Test
    public void dUpdate()
    {
        String newRaceID = "789";

        EmployeeRace desc = new EmployeeRace.Builder().copy(getSavedEmployeeRace()).getRaceId(newRaceID).build();
        System.out.println("In update, about_to_updated = " + desc);

        EmployeeRace updated = this.repository.update(desc);
        System.out.println("In update, updated = " + updated);

        Assert.assertEquals(newRaceID, updated.getRaceId());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<EmployeeRace> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }

    @Test
    public void fDelete()
    {
        EmployeeRace savedEmployeeRace = getSavedEmployeeRace();
        this.repository.delete(savedEmployeeRace.getRaceId());
        eGetAll();
    }
}