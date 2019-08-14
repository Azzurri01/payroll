
package com.djohannes.ac.za.repository.employee.impl;

import com.djohannes.ac.za.domain.employee.EmployeeGender;
import com.djohannes.ac.za.repository.employee.EmployeeGenderRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeGenderRepositoryImpl implements EmployeeGenderRepository {

    private static EmployeeGenderRepositoryImpl repository = null;
    private Set<EmployeeGender> employeeGenders;

    private EmployeeGenderRepositoryImpl() {
        this.employeeGenders = new HashSet<>();
    }

    private EmployeeGender search(final String employeeGenderId) {
        for (EmployeeGender employeeGenderSearch : this.employeeGenders) {
            if (employeeGenderSearch.getGenId().equals(employeeGenderId))
                return employeeGenderSearch;
        }
        return null;
    }

    public static EmployeeGenderRepositoryImpl getRepository(){
        if(repository == null) repository = new EmployeeGenderRepositoryImpl();
        return repository;
    }

    public EmployeeGender create(EmployeeGender employeeGender){
        this.employeeGenders.add(employeeGender);
        return employeeGender;
    }

    public EmployeeGender read(final String employeeGenderId){
        //find the student in the set and return it if it exist
        EmployeeGender employeeGender = search(employeeGenderId);
        return employeeGender;
    }

    public EmployeeGender update(EmployeeGender employeeGender) {
        // find the student, update it and return the updated student
        EmployeeGender toDelete = search(employeeGender.getGenId());
        if(toDelete != null) {
            this.employeeGenders.remove(toDelete);
            return create(employeeGender);
        }
        return null;
    }

    public void delete(String employeeId) {
        //find the student and delete it if it exists
        EmployeeGender employeeGender = search(employeeId);
        if (employeeGender != null) this.employeeGenders.remove(employeeGender);
    }

    public Set<EmployeeGender> getAll(){
        return this.employeeGenders;
    }
}
