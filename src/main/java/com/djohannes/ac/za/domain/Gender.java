package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Gender
{
    private String id, gen;

    private Gender(Builder builder)
    {
        this.id=builder.id;
        this.gen=builder.gen;
    }

    public String getId()
    {
        return id;
    }
    public String getGender()
    {
        return gen;
    }

    public static class Builder
    {
        private String id, gen;

        public Builder copy(Gender gender)
        {
            this.id=gender.id;
            this.gen=gender.id;
            return this;
        }

        public Builder getId(String id)
        {
            this.id=id;
            return this;
        }

        public Builder getGender(String gender)
        {
            this.gen=gender;
            return this;
        }

        public Gender build()
        {
            return new Gender(this);
        }
    }

    @Override
    public String toString() {
        return "Gender{" +
                "Id='" + id + '\'' +
                "Gender='" + gen + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender = (Gender) o;
        return id.equals(gender.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
