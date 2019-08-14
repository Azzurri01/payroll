package com.djohannes.ac.za.factory.employee;

import com.djohannes.ac.za.domain.employee.Employee;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    @Test
    public void getEmployee()
    {
        Employee employee = EmployeeFactory.getEmployee("Dimitri", "Johannes", "0824512653", "dimitri.johannes@gmail.com");
        Assert.assertNotNull(employee.getId());
        Assert.assertEquals("Dimitri", employee.getName());
        Assert.assertEquals("Johannes", employee.getSurname());
        Assert.assertEquals("0824512653", employee.getTel());
        Assert.assertEquals("dimitri.johannes@gmail.com", employee.getEmail());
    }
}