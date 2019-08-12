package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Employee
{
    private String id, name, surname, tel, email;
    private Gender gender;
    private Race race;

    private Employee(Builder builder)
    {
        this.id=builder.id;
        this.name=builder.name;
        this.surname=builder.surname;
        this.tel=builder.tel;
        this.email=builder.email;
        this.gender=builder.gender;
        this.race=builder.race;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getTel()
    {
        return tel;
    }

    public String getEmail()
    {
        return email;
    }

    public Gender getGender()
    {
        return gender;
    }

    public Race getRace()
    {
        return race;
    }

    public static class Builder {
        private String id, name, surname, tel, email;
        private Gender gender;
        private Race race;

        public Builder copy(Employee employee)
        {
            this.id=employee.id;
            this.name=employee.name;
            this.surname=employee.surname;
            this.tel=employee.tel;
            this.email=employee.email;
            this.gender=employee.gender;
            this.race=employee.race;
            return this;
        }

        public Builder getId(String id) {
            this.id = id;
            return this;
        }

        public Builder getName(String name) {
            this.name = name;
            return this;
        }

        public Builder getSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder getTel(String tel) {
            this.tel = tel;
            return this;
        }

        public Builder getEmail(String email)
        {
            this.email=email;
            return this;
        }

        public Builder getGender(Gender gender)
        {
            this.gender=gender;
            return this;
        }

        public Builder getRace(Race race)
        {
            this.race=race;
            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id='" + id + '\'' +
                "Name='" + name + '\'' +
                "Surname='" + surname + '\'' +
                "Tel='" + tel + '\'' +
                "Email='" + email + '\'' +
                "Gender='" + gender + '\'' +
                "Race='" + race + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee= (Employee) o;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
