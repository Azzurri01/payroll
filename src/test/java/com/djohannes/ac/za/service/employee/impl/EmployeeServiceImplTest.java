package com.djohannes.ac.za.service.employee.impl;

import com.djohannes.ac.za.domain.employee.Employee;
import com.djohannes.ac.za.factory.employee.EmployeeFactory;
import com.djohannes.ac.za.repository.employee.EmployeeRepository;
import com.djohannes.ac.za.repository.employee.impl.EmployeeRepositoryImpl;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceImplTest {


    private EmployeeRepository repository;

    private Employee getSavedEmployee(){
        Set<Employee> savedEmployee = this.repository.getAll();
        return savedEmployee.iterator().next();
    }



    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        Set<Employee>employeeEmployeeemployees = this.repository.getAll();
        System.out.println("In getall, all: " + employeeEmployeeemployees);
        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void a_create() {
        Employee employeeEmployee = EmployeeFactory.getEmployee("123", "456");
        Employee newSname = this.repository.create(employeeEmployee);
        System.out.println(newSname);

        Assert.assertEquals(1, this.repository.getAll().size());
        Assert.assertNotNull(newSname.getSurname());
    }

    @Test
    public void c_update() {
        String newSurname = "Davids";

        Employee employee = new Employee.Builder().copy(getSavedEmployee()).getSurname(newSurname).build();

        repository.create(employee);
        Employee inRepo = this.repository.update(employee);

        repository.update(employee);
        System.out.println(employee.getSurname() + " " + inRepo.getSurname());
        Assert.assertNotNull(employee.getId());
    }

    @Test
    public void e_delete() {
        Employee saved = getSavedEmployee();
        this.repository.delete(saved.getSurname());

        System.out.println("In array after deleted: " + repository.getAll());

        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void b_read() {
        Employee savedEmployee = getSavedEmployee();
        Employee read = this.repository.read(savedEmployee.getId());
        System.out.println("In read: " + read);
        Assert.assertSame(read,savedEmployee);
    }
}