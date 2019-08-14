package com.djohannes.ac.za.service.demography;

import com.djohannes.ac.za.domain.demography.Gender;
import com.djohannes.ac.za.service.IService;

import java.util.Set;

public interface GenderService extends IService<Gender, String>
{
    Set<Gender> getAll();
}
