package com.djohannes.ac.za.service.employee;

import com.djohannes.ac.za.domain.employee.EmployeeGender;
import com.djohannes.ac.za.service.IService;

import java.util.Set;

public interface EmployeeGenderService extends IService<EmployeeGender, String>
{
    Set<EmployeeGender> getAll();
}
