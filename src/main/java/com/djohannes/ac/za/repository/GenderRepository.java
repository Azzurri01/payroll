package com.djohannes.ac.za.repository;

import com.djohannes.ac.za.domain.Gender;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String>
{
    Set<Gender> getAll();
}
