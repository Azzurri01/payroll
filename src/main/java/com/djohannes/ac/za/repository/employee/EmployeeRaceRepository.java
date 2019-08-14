package com.djohannes.ac.za.repository.employee;

import com.djohannes.ac.za.domain.employee.EmployeeRace;
import com.djohannes.ac.za.repository.IRepository;

import java.util.Set;

public interface EmployeeRaceRepository extends IRepository<EmployeeRace, String>
{
    Set<EmployeeRace> getAll();
}
