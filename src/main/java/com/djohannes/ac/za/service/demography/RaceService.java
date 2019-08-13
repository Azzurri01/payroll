package com.djohannes.ac.za.service.demography;

import com.djohannes.ac.za.domain.demography.Race;
import com.djohannes.ac.za.service.IService;

import java.util.Set;

public interface RaceService extends IService<Race, String>
{
    Set<Race> getAll();
}
