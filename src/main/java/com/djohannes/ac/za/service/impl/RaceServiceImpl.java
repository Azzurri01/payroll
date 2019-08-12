package com.djohannes.ac.za.service.impl;

import com.djohannes.ac.za.domain.Race;
import com.djohannes.ac.za.repository.RaceRepository;
import com.djohannes.ac.za.repository.impl.RaceRepositoryImpl;
import com.djohannes.ac.za.service.RaceService;

import java.util.Set;

public class RaceServiceImpl implements RaceService {

    private static RaceServiceImpl service = null;

    private RaceRepository repository;

    private RaceServiceImpl() {
        this.repository = RaceRepositoryImpl.getRepository();
    }

    public static RaceServiceImpl getService(){
        if (service == null) service = new RaceServiceImpl();
        return service;
    }

    public Race create(Race race) {
        return this.repository.create(race);
    }

    public Race update(Race race) {
        return this.repository.update(race);
    }

    public void delete(String s) {
        this.repository.delete(s);
    }

    public Race read(String s) {
        return this.repository.read(s);
    }

    public Set<Race> getAll() {
        return this.repository.getAll();
    }
}
