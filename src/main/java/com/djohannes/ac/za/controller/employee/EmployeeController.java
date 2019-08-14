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

    public Employee create(String name, String surname, String gen, String rac)
    {
        //Initialise objects
        Employee employee = employeeService.create(EmployeeFactory.getEmployee(name, surname));
        Gender gender = genderService.create(GenderFactory.getGender(gen));
        Race race = raceService.create(RaceFactory.getRace(rac));

        //Create Objects
        employeeService.create(employee);
        genderService.create(gender);
        raceService.create(race);

        //Get employee gender and race
        employeeGenderService.create(EmployeeGenderFactory.getEmployeeGender(employee.getId(), gender.getId()));
        employeeRaceService.create(EmployeeRaceFactory.getEmployeeRace(employee.getId(), race.getId()));

        return employee;
    }
}
