package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Employee;
import com.djohannes.ac.za.domain.Gender;
import com.djohannes.ac.za.domain.Race;
import com.djohannes.ac.za.util.Misc;

public class EmployeeFactory
{
    public static Employee getEmployee(String name, String surname, String tel, String email, Gender gender, Race race)
    {
        return new Employee.Builder()
                .getId(Misc.generateId())
                .getName(name)
                .getSurname(surname)
                .getTel(tel)
                .getEmail(email)
                .getGender(gender)
                .getRace(race)
                .build();
    }
}
