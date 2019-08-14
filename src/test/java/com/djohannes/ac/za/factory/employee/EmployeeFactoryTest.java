package com.djohannes.ac.za.factory.employee;

import com.djohannes.ac.za.domain.employee.Employee;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    @Test
    public void getEmployee()
    {
        Employee employee = EmployeeFactory.getEmployee("Dimitri", "Johannes");
        Assert.assertNotNull(employee.getId());
        Assert.assertEquals("Dimitri", employee.getName());
        Assert.assertEquals("Johannes", employee.getSurname());
    }
}