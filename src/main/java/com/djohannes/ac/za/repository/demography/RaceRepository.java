package com.djohannes.ac.za.repository.demography;

import com.djohannes.ac.za.domain.demography.Race;
import com.djohannes.ac.za.repository.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String>
{
Set<Race> getAll();
}
