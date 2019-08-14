package com.djohannes.ac.za.domain.employee;

import java.util.Objects;

public class Employee
{
    private String id, name, surname;

    private Employee(Builder builder)
    {
        this.id=builder.id;
        this.name=builder.name;
        this.surname=builder.surname;
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

    public static class Builder {
        private String id, name, surname;

        public Builder copy(Employee employee)
        {
            this.id=employee.id;
            this.name=employee.name;
            this.surname=employee.surname;
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

        public Employee build()
        {
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "EmployeeController{" +
                "Id='" + id + '\'' +
                "Name='" + name + '\'' +
                "Surname='" + surname + '\'' +
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
