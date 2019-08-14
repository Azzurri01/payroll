package com.djohannes.ac.za.controller.employee;

import com.djohannes.ac.za.domain.demography.Gender;
import com.djohannes.ac.za.domain.demography.Race;
import com.djohannes.ac.za.domain.employee.Employee;
import com.djohannes.ac.za.factory.demography.GenderFactory;
import com.djohannes.ac.za.factory.demography.RaceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeControllerTest
{
    @Test
    public void create()
    {
        EmployeeController empController = new EmployeeController();
        Gender gender = GenderFactory.getGender("male");
        Race race = RaceFactory.getRace("coloured");
        Employee employee = empController.create("Dimitri", "Johannes", gender.getGender(), race.getRace());
        Assert.assertNotNull(employee);
        Assert.assertNotNull(employee.getId());
        Assert.assertNotNull(gender.getId());
        Assert.assertNotNull(race.getId());
        Assert.assertEquals("Dimitri", employee.getName());
        Assert.assertEquals("Johannes", employee.getSurname());
        Assert.assertEquals("male",gender.getGender());
        Assert.assertEquals("coloured", race.getRace());
    }
}