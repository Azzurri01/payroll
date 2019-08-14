
package com.djohannes.ac.za.repository.employee.impl;

import com.djohannes.ac.za.domain.employee.Employee;
import com.djohannes.ac.za.repository.employee.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl repository = null;
    private Set<Employee> employees;

    private EmployeeRepositoryImpl() {
        this.employees = new HashSet<>();
    }

    private Employee search(final String employeeEmployeeId) {
        for (Employee employeeEmployeeSearch : this.employees) {
            if (employeeEmployeeSearch.getId().equals(employeeEmployeeId))
                return employeeEmployeeSearch;
        }
        return null;
    }

    public static EmployeeRepositoryImpl getRepository(){
        if(repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }

    public Employee create(Employee employee){
        this.employees.add(employee);
        return employee;
    }

    public Employee read(final String employeeId){
        //find the student in the set and return it if it exist
        Employee employee = search(employeeId);
        return employee;
    }

    public Employee update(Employee employee) {
        // find the student, update it and return the updated student
        Employee toDelete = search(employee.getId());
        if(toDelete != null) {
            this.employees.remove(toDelete);
            return create(employee);
        }
        return null;
    }

    public void delete(String employeeId) {
        //find the student and delete it if it exists
        Employee employee = search(employeeId);
        if (employee != null) this.employees.remove(employee);
    }

    public Set<Employee> getAll(){
        return this.employees;
    }
}
