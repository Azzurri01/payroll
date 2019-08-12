package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Race;

import java.util.Set;

public interface RaceService extends IService<Race, String>
{
    Set<Race> getAll();
}
