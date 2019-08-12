
package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Gender;
import com.djohannes.ac.za.repository.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {

    private static GenderRepositoryImpl repository = null;
    private Set<Gender> genders;

    private GenderRepositoryImpl() {
        this.genders = new HashSet<>();
    }

    private Gender search(final String employeeGenderId) {
        for (Gender employeeGenderSearch : this.genders) {
            if (employeeGenderSearch.getId().equals(employeeGenderId))
                return employeeGenderSearch;
        }
        return null;
    }

    public static GenderRepositoryImpl getRepository(){
        if(repository == null) repository = new GenderRepositoryImpl();
        return repository;
    }

    public Gender create(Gender gender){
        this.genders.add(gender);
        return gender;
    }

    public Gender read(final String genderId){
        //find the student in the set and return it if it exist
        Gender gender = search(genderId);
        return gender;
    }

    public Gender update(Gender gender) {
        // find the student, update it and return the updated student
        Gender toDelete = search(gender.getId());
        if(toDelete != null) {
            this.genders.remove(toDelete);
            return create(gender);
        }
        return null;
    }

    public void delete(String genderId) {
        //find the student and delete it if it exists
        Gender gender = search(genderId);
        if (gender != null) this.genders.remove(gender);
    }

    public Set<Gender> getAll(){
        return this.genders;
    }
}
