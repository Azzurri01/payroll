package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Employee;
import com.djohannes.ac.za.repository.EmployeeRepository;
import com.djohannes.ac.za.repository.impl.EmployeeRepositoryImpl;
import com.djohannes.ac.za.service.EmployeeService;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeServiceImpl service = null;

    private EmployeeRepository repository;

    private EmployeeServiceImpl() {
        this.repository = EmployeeRepositoryImpl.getRepository();
    }

    public static EmployeeServiceImpl getService(){
        if (service == null) service = new EmployeeServiceImpl();
        return service;
    }

    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }

    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }

    public void delete(String s) {
        this.repository.delete(s);
    }

    public Employee read(String s) {
        return this.repository.read(s);
    }

    public Set<Employee> getAll() {
        return this.repository.getAll();
    }
}
