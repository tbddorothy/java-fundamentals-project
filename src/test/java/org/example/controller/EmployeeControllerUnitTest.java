package org.example.controller;

import org.example.model.dto.EmployeeDto;
import org.example.model.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

import java.awt.*;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerUnitTest {

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
    public void setUp(){
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void GetEmployeesTest() throws Exception{
        Employee testEmployee =new Employee(0L, "guy@mail.com", "Guy", "Guy", "ceo");
        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(testEmployee));

        String uri = "/employee/employees";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);


    }
    @Test
    public void AddEmployeesTest()throws Exception{
        Employee testEmployee =new Employee(0L, "guy@mail.com", "Guy", "Guy", "ceo");
        when(employeeService.addEmployee(testEmployee)).thenReturn(testEmployee);

        String uri = "/employee/employees";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();


        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
