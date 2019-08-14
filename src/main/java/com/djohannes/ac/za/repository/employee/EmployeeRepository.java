package com.djohannes.ac.za.repository.employee;

import com.djohannes.ac.za.domain.employee.Employee;
import com.djohannes.ac.za.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String>
{
    Set<Employee> getAll();
}
