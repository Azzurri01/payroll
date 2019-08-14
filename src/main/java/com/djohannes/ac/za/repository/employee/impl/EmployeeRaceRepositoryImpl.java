
package com.djohannes.ac.za.repository.employee.impl;

import com.djohannes.ac.za.domain.employee.EmployeeRace;
import com.djohannes.ac.za.repository.employee.EmployeeRaceRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRaceRepositoryImpl implements EmployeeRaceRepository {

    private static EmployeeRaceRepositoryImpl repository = null;
    private Set<EmployeeRace> employeeRaces;

    private EmployeeRaceRepositoryImpl() {
        this.employeeRaces = new HashSet<>();
    }

    private EmployeeRace search(final String employeeRaceId) {
        for (EmployeeRace employeeRaceSearch : this.employeeRaces) {
            if (employeeRaceSearch.getRaceId().equals(employeeRaceId))
                return employeeRaceSearch;
        }
        return null;
    }

    public static EmployeeRaceRepositoryImpl getRepository(){
        if(repository == null) repository = new EmployeeRaceRepositoryImpl();
        return repository;
    }

    public EmployeeRace create(EmployeeRace employeeRace){
        this.employeeRaces.add(employeeRace);
        return employeeRace;
    }

    public EmployeeRace read(final String employeeRaceId){
        //find the student in the set and return it if it exist
        EmployeeRace employeeRace = search(employeeRaceId);
        return employeeRace;
    }

    public EmployeeRace update(EmployeeRace employeeRace) {
        // find the student, update it and return the updated student
        EmployeeRace toDelete = search(employeeRace.getRaceId());
        if(toDelete != null) {
            this.employeeRaces.remove(toDelete);
            return create(employeeRace);
        }
        return null;
    }

    public void delete(String employeeId) {
        //find the student and delete it if it exists
        EmployeeRace employeeRace = search(employeeId);
        if (employeeRace != null) this.employeeRaces.remove(employeeRace);
    }

    public Set<EmployeeRace> getAll(){
        return this.employeeRaces;
    }
}
