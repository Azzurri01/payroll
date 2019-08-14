package com.djohannes.ac.za.service.employee;

import com.djohannes.ac.za.domain.employee.Employee;
import com.djohannes.ac.za.service.IService;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String>
{
    Set<Employee> getAll();
}
