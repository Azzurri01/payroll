package com.djohannes.ac.za.repository.employee;

import com.djohannes.ac.za.domain.employee.EmployeeGender;
import com.djohannes.ac.za.repository.IRepository;

import java.util.Set;

public interface EmployeeGenderRepository extends IRepository<EmployeeGender, String>
{
    Set<EmployeeGender> getAll();
}
