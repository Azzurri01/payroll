package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.Gender;

import java.util.Set;

public interface GenderService extends IService<Gender, String>
{
    Set<Gender> getAll();
}
