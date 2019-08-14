package com.djohannes.ac.za.service.employee.impl;

import com.djohannes.ac.za.domain.employee.EmployeeRace;
import com.djohannes.ac.za.repository.employee.EmployeeRaceRepository;
import com.djohannes.ac.za.repository.employee.impl.EmployeeRaceRepositoryImpl;
import com.djohannes.ac.za.service.employee.EmployeeRaceService;

import java.util.Set;

public class EmployeeRaceServiceImpl implements EmployeeRaceService {

    private static EmployeeRaceServiceImpl service = null;

    private EmployeeRaceRepository repository;

    private EmployeeRaceServiceImpl() {
        this.repository = EmployeeRaceRepositoryImpl.getRepository();
    }

    public static EmployeeRaceServiceImpl getService(){
        if (service == null) service = new EmployeeRaceServiceImpl();
        return service;
    }

    public EmployeeRace create(EmployeeRace employeeRace) {
        return this.repository.create(employeeRace);
    }

    public EmployeeRace update(EmployeeRace employeeRace) {
        return this.repository.update(employeeRace);
    }

    public void delete(String s) {
        this.repository.delete(s);
    }

    public EmployeeRace read(String s) {
        return this.repository.read(s);
    }

    public Set<EmployeeRace> getAll() {
        return this.repository.getAll();
    }
}
