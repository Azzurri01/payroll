package com.djohannes.ac.za.factory.employee;

import com.djohannes.ac.za.domain.employee.Employee;
import com.djohannes.ac.za.util.Misc;

public class EmployeeFactory
{
    public static Employee getEmployee(String name, String surname)
    {
        return new Employee.Builder()
                .getId(Misc.generateId())
                .getName(name)
                .getSurname(surname)
                .build();
    }
}
