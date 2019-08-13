package com.djohannes.ac.za.service.employee.impl;

import com.djohannes.ac.za.domain.employee.EmployeeGender;
import com.djohannes.ac.za.repository.employee.EmployeeGenderRepository;
import com.djohannes.ac.za.repository.employee.impl.EmployeeGenderRepositoryImpl;
import com.djohannes.ac.za.service.employee.EmployeeGenderService;

import java.util.Set;

public class EmployeeGenderServiceImpl implements EmployeeGenderService {

    private static EmployeeGenderServiceImpl service = null;

    private EmployeeGenderRepository repository;

    private EmployeeGenderServiceImpl() {
        this.repository = EmployeeGenderRepositoryImpl.getRepository();
    }

    public static EmployeeGenderServiceImpl getService(){
        if (service == null) service = new EmployeeGenderServiceImpl();
        return service;
    }

    public EmployeeGender create(EmployeeGender employeeGender) {
        return this.repository.create(employeeGender);
    }

    public EmployeeGender update(EmployeeGender employeeGender) {
        return this.repository.update(employeeGender);
    }

    public void delete(String s) {
        this.repository.delete(s);
    }

    public EmployeeGender read(String s) {
        return this.repository.read(s);
    }

    public Set<EmployeeGender> getAll() {
        return this.repository.getAll();
    }
}
