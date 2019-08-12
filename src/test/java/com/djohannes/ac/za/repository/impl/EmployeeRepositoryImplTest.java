package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Employee;
import com.djohannes.ac.za.domain.Gender;
import com.djohannes.ac.za.domain.Race;
import com.djohannes.ac.za.factory.EmployeeFactory;
import com.djohannes.ac.za.factory.GenderFactory;
import com.djohannes.ac.za.factory.RaceFactory;
import com.djohannes.ac.za.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImplTest {

    private EmployeeRepository repository;
    private Employee employee;

    private Employee getSavedEmployee()
    {
        Set<Employee> savedPopulation = this.repository.getAll();
        return  savedPopulation.iterator().next();
    }

    @Before
    public void setUp() throws Exception
    {
        this.repository = EmployeeRepositoryImpl.getRepository();
        Gender gender = GenderFactory.getGender("Male");
        Race race = RaceFactory.getRace("Coloured");
        this.employee = EmployeeFactory.getEmployee("Dimitri", "Johannes", "0824512653", "dimitri.johannes@gmail.com", gender, race);
    }

    @Test
    public void aGetRepository()
    {
        Assert.assertNotNull(repository);
    }

    @Test
    public void bCreate()
    {
        Employee createdEmployee = this.repository.create(this.employee);
        System.out.println("Create method called: Created employee = " + this.employee);
        eGetAll();
        Assert.assertSame(createdEmployee, this.employee);
    }

    @Test
    public void cRead()
    {
        Employee savedEmployee = getSavedEmployee();
        System.out.println("Read method call 1: Reading EmployeeID = " + savedEmployee.getId());
        Employee readEmployee = this.repository.read(savedEmployee.getId());
        System.out.println("Read method call 2: Reading read = " + savedEmployee);
        eGetAll();
        Assert.assertSame(savedEmployee, readEmployee);
    }

    @Test
    public void dUpdate()
    {
        String newTel = "0835133305";

        Employee desc = new Employee.Builder().copy(getSavedEmployee()).getTel(newTel).build();
        System.out.println("In update, about_to_updated = " + desc);

        Employee updated = this.repository.update(desc);
        System.out.println("In update, updated = " + updated);

        Assert.assertEquals(newTel, updated.getTel());
        eGetAll();
    }

    @Test
    public void eGetAll()
    {
        Set<Employee> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }

    @Test
    public void fDelete()
    {
        Employee savedEmployee = getSavedEmployee();
        this.repository.delete(savedEmployee.getId());
        eGetAll();
    }
}