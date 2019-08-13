package com.djohannes.ac.za.factory.demography;

import com.djohannes.ac.za.domain.demography.Gender;
import org.junit.Assert;
import org.junit.Test;

public class GenderFactoryTest {

    @Test
    public void getGender()
    {
        Gender gender = GenderFactory.getGender("Male");
        Assert.assertNotNull(gender.getId());
        Assert.assertEquals("Male", gender.getGender());
    }
}