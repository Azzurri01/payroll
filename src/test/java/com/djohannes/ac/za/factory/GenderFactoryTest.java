package com.djohannes.ac.za.factory;

import com.djohannes.ac.za.domain.Gender;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderFactoryTest {

    @Test
    public void getGender()
    {
        Gender gender = GenderFactory.getGender("Male");
        Assert.assertEquals("Male", gender.getGender());
    }
}