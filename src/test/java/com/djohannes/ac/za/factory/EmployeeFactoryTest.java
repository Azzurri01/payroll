package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Employee;
import com.djohannes.ac.za.domain.Gender;
import com.djohannes.ac.za.domain.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    @Test
    public void getEmployee()
    {
        Gender gender = GenderFactory.getGender("Male");
        Race race = RaceFactory.getRace("Coloured");
        Employee employee = EmployeeFactory.getEmployee("Dimitri", "Johannes", "0824512653", "dimitri.johannes@gmail.com", gender, race);
        Assert.assertEquals("Dimitri", employee.getName());
        Assert.assertEquals("Johannes", employee.getSurname());
        Assert.assertEquals("0824512653", employee.getTel());
        Assert.assertEquals("dimitri.johannes@gmail.com", employee.getEmail());
        Assert.assertEquals("Male", employee.getGender().getGender());
        Assert.assertEquals("Coloured", employee.getRace().getRace());
    }
}