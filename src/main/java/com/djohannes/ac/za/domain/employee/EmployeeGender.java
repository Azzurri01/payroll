package com.djohannes.ac.za.domain.employee;

import java.util.Objects;

public class EmployeeGender
{
    private String empId, genId;

    private EmployeeGender(Builder builder)
    {
        this.empId=builder.empId;
        this.genId=builder.genId;
    }

    public String getEmpId()
    {
        return this.empId;
    }

    public String getGenId()
    {
        return this.genId;
    }

    public static class Builder
    {
        private String empId, genId;

        public Builder copy(EmployeeGender employeeGender)
        {
            this.empId=employeeGender.empId;
            this.genId=employeeGender.genId;
            return this;
        }

        public Builder getEmpId(String empId)
        {
            this.empId=empId;
            return this;
        }

        public Builder getGenId(String genId)
        {
            this.genId=genId;
            return this;
        }

        public EmployeeGender build()
        {
            return new EmployeeGender(this);
        }
    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "EmployeeID='" + empId + '\'' +
                "GenderID='" + genId + '\'' +
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
