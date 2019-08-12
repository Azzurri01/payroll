package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Race;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String>
{
Set<Race> getAll();
}
