package org.example.controller;

import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.example.service.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mvc;

    @Mock
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @InjectMocks
    private EmployeeController employeeController;

    @Before
    public void setUp() {
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getEmployeesTest () throws Exception {
        Employee testEmployee = new Employee(0L, "guy@gmail.com", "Guy", "Piet", "Developer");
        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(testEmployee));

        String uri = "/employee/employees";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
    }

    @Test
    public void addEmployeesTest () throws Exception {
        Employee testEmployee = new Employee(0L, "guy@gmail.com", "Guy", "Piet", "Developer");
        when(employeeService.addEmployee(testEmployee)).thenReturn(testEmployee);

        String uri = "/employee/employees";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
    }

}
