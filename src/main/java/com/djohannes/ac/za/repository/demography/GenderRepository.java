package com.djohannes.ac.za.repository.demography;

import com.djohannes.ac.za.domain.demography.Gender;
import com.djohannes.ac.za.repository.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String>
{
    Set<Gender> getAll();
}
