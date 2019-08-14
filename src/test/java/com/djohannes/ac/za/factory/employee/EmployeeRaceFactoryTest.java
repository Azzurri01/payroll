package com.djohannes.ac.za.factory.employee;

import com.djohannes.ac.za.domain.demography.Gender;
import com.djohannes.ac.za.domain.demography.Race;
import com.djohannes.ac.za.domain.employee.Employee;
import com.djohannes.ac.za.domain.employee.EmployeeRace;
import com.djohannes.ac.za.factory.demography.GenderFactory;
import com.djohannes.ac.za.factory.demography.RaceFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRaceFactoryTest {

    @Test
    public void getEmployeeRace()
    {
        Employee employee = EmployeeFactory.getEmployee("Dimitri", "Johannes");
        Race race = RaceFactory.getRace("Coloured");

        EmployeeRace employeeRace = EmployeeRaceFactory.getEmployeeRace("123","456");

        Assert.assertNotNull(employee.getId());
        Assert.assertNotNull(race.getId());

        Assert.assertEquals("123", employeeRace.getEmpId());
        Assert.assertEquals("456", employeeRace.getRaceId());
    }
}