package com.djohannes.ac.za.service.demography.impl;

import com.djohannes.ac.za.domain.demography.Gender;
import com.djohannes.ac.za.repository.demography.GenderRepository;
import com.djohannes.ac.za.repository.demography.impl.GenderRepositoryImpl;
import com.djohannes.ac.za.service.demography.GenderService;

import java.util.Set;

public class GenderServiceImpl implements GenderService {

    private static GenderServiceImpl service = null;

    private GenderRepository repository;

    private GenderServiceImpl() {
        this.repository = GenderRepositoryImpl.getRepository();
    }

    public static GenderServiceImpl getService(){
        if (service == null) service = new GenderServiceImpl();
        return service;
    }

    public Gender create(Gender gender) {
        return this.repository.create(gender);
    }

    public Gender update(Gender gender) {
        return this.repository.update(gender);
    }

    public void delete(String s) {
        this.repository.delete(s);
    }

    public Gender read(String s) {
        return this.repository.read(s);
    }

    public Set<Gender> getAll() {
        return this.repository.getAll();
    }
}
