package com.djohannes.ac.za.factory.employee;

import com.djohannes.ac.za.domain.demography.Gender;
import com.djohannes.ac.za.domain.employee.Employee;
import com.djohannes.ac.za.domain.employee.EmployeeGender;

public class EmployeeGenderFactory
{
    public static EmployeeGender getEmployeeGender(String empId, String genId)
    {
        return new EmployeeGender.Builder()
                .getEmpId(empId)
                .getGenId(genId)
                .build();
    }
}
