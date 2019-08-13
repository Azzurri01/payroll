package com.djohannes.ac.za.service.employee;

import com.djohannes.ac.za.domain.employee.EmployeeRace;
import com.djohannes.ac.za.service.IService;

import java.util.Set;

public interface EmployeeRaceService extends IService<EmployeeRace, String>
{
    Set<EmployeeRace> getAll();
}
