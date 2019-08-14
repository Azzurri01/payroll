package com.djohannes.ac.za.service.employee.impl;

import com.djohannes.ac.za.domain.employee.EmployeeGender;
import com.djohannes.ac.za.factory.employee.EmployeeGenderFactory;
import com.djohannes.ac.za.repository.employee.EmployeeGenderRepository;
import com.djohannes.ac.za.repository.employee.impl.EmployeeGenderRepositoryImpl;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeGenderServiceImplTest {


    private EmployeeGenderRepository repository;

    private EmployeeGender getSavedEmployeeGender(){
        Set<EmployeeGender> savedEmployeeGender = this.repository.getAll();
        return savedEmployeeGender.iterator().next();
    }



    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeGenderRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        Set<EmployeeGender>employeeEmployeeemployeeGenders = this.repository.getAll();
        System.out.println("In getall, all: " + employeeEmployeeemployeeGenders);
        Assert.assertEquals(2,this.repository.getAll().size());
    }

    @Test
    public void a_create() {
        EmployeeGender employeeEmployeeGender = EmployeeGenderFactory.getEmployeeGender("123", "456");
        EmployeeGender newGen = this.repository.create(employeeEmployeeGender);
        System.out.println(newGen);

        Assert.assertEquals(1, this.repository.getAll().size());
        Assert.assertNotNull(newGen.getEmpId());
        Assert.assertNotNull(newGen.getGenId());
    }

    @Test
    public void c_update() {
        EmployeeGender employeeGender = EmployeeGenderFactory.getEmployeeGender("222", "333");

        repository.create(employeeGender);
        EmployeeGender inRepo = repository.read(employeeGender.getGenId());

        repository.update(employeeGender);
        System.out.println(employeeGender.getGenId() + " " + inRepo.getGenId());
        Assert.assertNotNull(employeeGender.getEmpId());
        Assert.assertNotNull(employeeGender.getGenId());
    }

    @Test
    public void e_delete() {
        EmployeeGender saved = getSavedEmployeeGender();
        this.repository.delete(saved.getEmpId());

        System.out.println("In array after deleted: " + repository.getAll());

        Assert.assertEquals(2,this.repository.getAll().size());
    }

    @Test
    public void b_read() {
        EmployeeGender savedEmployeeGender = getSavedEmployeeGender();
        EmployeeGender read = this.repository.read(savedEmployeeGender.getGenId());
        System.out.println("In read: " + read);
        Assert.assertSame(read,savedEmployeeGender);
    }
}