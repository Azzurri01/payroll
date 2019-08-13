package com.djohannes.ac.za.factory.employee;

import com.djohannes.ac.za.domain.demography.Race;
import com.djohannes.ac.za.domain.employee.Employee;
import com.djohannes.ac.za.domain.employee.EmployeeRace;

public class EmployeeRaceFactory
{
    public static EmployeeRace getEmployeeRace(String empId, String raceId)
    {
        return new EmployeeRace.Builder()
                .getEmpId(empId)
                .getRaceId(raceId)
                .build();
    }
}
