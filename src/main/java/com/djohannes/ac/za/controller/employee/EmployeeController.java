package com.djohannes.ac.za.controller.employee;

import com.djohannes.ac.za.domain.demography.Gender;
import com.djohannes.ac.za.domain.demography.Race;
import com.djohannes.ac.za.domain.employee.Employee;
import com.djohannes.ac.za.domain.employee.EmployeeGender;
import com.djohannes.ac.za.domain.employee.EmployeeRace;
import com.djohannes.ac.za.factory.demography.GenderFactory;
import com.djohannes.ac.za.factory.demography.RaceFactory;
import com.djohannes.ac.za.factory.employee.EmployeeFactory;
import com.djohannes.ac.za.factory.employee.EmployeeGenderFactory;
import com.djohannes.ac.za.factory.employee.EmployeeRaceFactory;
import com.djohannes.ac.za.service.demography.GenderService;
import com.djohannes.ac.za.service.demography.RaceService;
import com.djohannes.ac.za.service.demography.impl.GenderServiceImpl;
import com.djohannes.ac.za.service.demography.impl.RaceServiceImpl;
import com.djohannes.ac.za.service.employee.EmployeeGenderService;
import com.djohannes.ac.za.service.employee.EmployeeRaceService;
import com.djohannes.ac.za.service.employee.EmployeeService;
import com.djohannes.ac.za.service.employee.impl.EmployeeGenderServiceImpl;
import com.djohannes.ac.za.service.employee.impl.EmployeeRaceServiceImpl;
import com.djohannes.ac.za.service.employee.impl.EmployeeServiceImpl;

public class EmployeeController
{
    private EmployeeService employeeService = EmployeeServiceImpl.getService();
    private EmployeeGenderService employeeGenderService = EmployeeGenderServiceImpl.getService();
    private EmployeeRaceService employeeRaceService = EmployeeRaceServiceImpl.getService();
    private GenderService genderService = GenderServiceImpl.getService();
    private RaceService raceService = RaceServiceImpl.getService();


    public void create() {
        Employee employee = EmployeeFactory.getEmployee("Dimitri", "Johannes", "0824512653", "dimitri.johannes@gmail.com");
        employeeService.create(employee);

        EmployeeGender employeeGender = EmployeeGenderFactory.getEmployeeGender("123", "456");
        employeeGenderService.create(employeeGender);

        EmployeeRace employeeRace = EmployeeRaceFactory.getEmployeeRace("123", "456");
        employeeRaceService.create(employeeRace);

        Gender gender = GenderFactory.getGender("Male");
        genderService.create(gender);

        Race race = RaceFactory.getRace("Coloured");
        raceService.create(race);
    }
}
