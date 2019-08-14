
package com.djohannes.ac.za.repository.demography.impl;

import com.djohannes.ac.za.domain.demography.Race;
import com.djohannes.ac.za.repository.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private static RaceRepositoryImpl repository = null;
    private Set<Race> races;

    private RaceRepositoryImpl() {
        this.races = new HashSet<>();
    }

    private Race search(final String employeeRaceId) {
        for (Race employeeRaceSearch : this.races) {
            if (employeeRaceSearch.getId().equals(employeeRaceId))
                return employeeRaceSearch;
        }
        return null;
    }

    public static RaceRepositoryImpl getRepository(){
        if(repository == null) repository = new RaceRepositoryImpl();
        return repository;
    }

    public Race create(Race race){
        this.races.add(race);
        return race;
    }

    public Race read(final String raceId){
        //find the student in the set and return it if it exist
        Race race = search(raceId);
        return race;
    }

    public Race update(Race race) {
        // find the student, update it and return the updated student
        Race toDelete = search(race.getId());
        if(toDelete != null) {
            this.races.remove(toDelete);
            return create(race);
        }
        return null;
    }

    public void delete(String raceId) {
        //find the student and delete it if it exists
        Race race = search(raceId);
        if (race != null) this.races.remove(race);
    }

    public Set<Race> getAll(){
        return this.races;
    }
}