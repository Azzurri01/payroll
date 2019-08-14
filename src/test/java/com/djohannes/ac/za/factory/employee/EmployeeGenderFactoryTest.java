package com.djohannes.ac.za.factory.employee;

import com.djohannes.ac.za.domain.demography.Gender;
import com.djohannes.ac.za.domain.employee.Employee;
import com.djohannes.ac.za.domain.employee.EmployeeGender;
import com.djohannes.ac.za.factory.demography.GenderFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeGenderFactoryTest {

    @Test
    public void getEmployeeGender()
    {
        Employee employee = EmployeeFactory.getEmployee("Dimitri", "Johannes");
        Gender gender = GenderFactory.getGender("Male");

        EmployeeGender employeeGender = EmployeeGenderFactory.getEmployeeGender("123", "456");

        Assert.assertNotNull(employee.getId());
        Assert.assertNotNull(gender.getId());

        Assert.assertEquals("123", employeeGender.getEmpId());
        Assert.assertEquals("456", employeeGender.getGenId());
    }
}