package com.djohannes.ac.za.service.employee.impl;

import com.djohannes.ac.za.domain.employee.EmployeeRace;
import com.djohannes.ac.za.factory.employee.EmployeeRaceFactory;
import com.djohannes.ac.za.repository.employee.EmployeeRaceRepository;
import com.djohannes.ac.za.repository.employee.impl.EmployeeRaceRepositoryImpl;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRaceServiceImplTest {


    private EmployeeRaceRepository repository;

    private EmployeeRace getSavedEmployeeRace(){
        Set<EmployeeRace> savedEmployeeRace = this.repository.getAll();
        return savedEmployeeRace.iterator().next();
    }



    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRaceRepositoryImpl.getRepository();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void d_getAll() {
        Set<EmployeeRace>employeeEmployeeemployeeRaces = this.repository.getAll();
        System.out.println("In getall, all: " + employeeEmployeeemployeeRaces);
        Assert.assertEquals(2,this.repository.getAll().size());
    }

    @Test
    public void a_create() {
        EmployeeRace employeeEmployeeRace = EmployeeRaceFactory.getEmployeeRace("123", "456");
        EmployeeRace newRace = this.repository.create(employeeEmployeeRace);
        System.out.println(newRace);

        Assert.assertEquals(1, this.repository.getAll().size());
        Assert.assertNotNull(newRace.getEmpId());
        Assert.assertNotNull(newRace.getRaceId());
    }

    @Test
    public void c_update() {
        EmployeeRace employeeRace = EmployeeRaceFactory.getEmployeeRace("222", "333");

        repository.create(employeeRace);
        EmployeeRace inRepo = repository.read(employeeRace.getRaceId());

        repository.update(employeeRace);
        System.out.println(employeeRace.getRaceId() + " " + inRepo.getRaceId());
        Assert.assertNotNull(employeeRace.getEmpId());
        Assert.assertNotNull(employeeRace.getRaceId());
    }

    @Test
    public void e_delete() {
        EmployeeRace saved = getSavedEmployeeRace();
        this.repository.delete(saved.getEmpId());

        System.out.println("In array after deleted: " + repository.getAll());

        Assert.assertEquals(2,this.repository.getAll().size());
    }

    @Test
    public void b_read() {
        EmployeeRace savedEmployeeRace = getSavedEmployeeRace();
        EmployeeRace read = this.repository.read(savedEmployeeRace.getRaceId());
        System.out.println("In read: " + read);
        Assert.assertSame(read,savedEmployeeRace);
    }
}