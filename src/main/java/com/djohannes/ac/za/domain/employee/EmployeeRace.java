package com.djohannes.ac.za.domain.employee;

import java.util.Objects;

public class EmployeeRace
{
    private String empId, raceId;

    private EmployeeRace(Builder builder)
    {
        this.empId=builder.empId;
        this.raceId=builder.raceId;
    }

    public String getEmpId()
    {
        return this.empId;
    }

    public String getRaceId()
    {
        return this.raceId;
    }

    public static class Builder
    {
        private String empId, raceId;

        public Builder copy(EmployeeRace employeeRace)
        {
            this.empId=employeeRace.empId;
            this.raceId=employeeRace.raceId;
            return this;
        }

        public Builder getEmpId(String empId)
        {
            this.empId=empId;
            return this;
        }

        public Builder getRaceId(String raceId)
        {
            this.raceId=raceId;
            return this;
        }

        public EmployeeRace build()
        {
            return new EmployeeRace(this);
        }
    }

    @Override
    public String toString() {
        return "EmployeeController{" +
                "EmployeeID='" + empId + '\'' +
                "RaceID='" + raceId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee= (Employee) o;
        return empId.equals(employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpId());
    }
}
