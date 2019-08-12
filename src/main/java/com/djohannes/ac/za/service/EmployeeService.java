package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Employee;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String>
{
    Set<Employee> getAll();
}
