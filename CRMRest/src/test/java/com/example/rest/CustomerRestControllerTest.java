package com.example.rest;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CustomerRestControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerRestController customerRestController;

    Customer cust1 = new Customer(1,"john","doe","doe@gmail.com");
    Customer cust2 = new Customer(2,"steve","smith","steve@gmail.com");
    Customer cust3 = new Customer(3,"tim","david","tim@gmail.com");



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerRestController).build();
    }

    @Test
     public void getCustomersSuccess() throws Exception {

////        MockitoAnnotations.initMocks(this);
//        MockitoAnnotations.openMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(customerRestController).build();

        List<Customer> customers = new ArrayList<>(Arrays.asList(cust1,cust2,cust3));

        Mockito.when(customerService.getCustomers()).thenReturn(customers);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[2].lastName",is("david")));

    }

    @Test
    public void getCustomersNotFound() throws Exception {

////        MockitoAnnotations.initMocks(this);
//        MockitoAnnotations.openMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(customerRestController).build();

        List<Customer> customers = new ArrayList<>(Arrays.asList(cust1,cust2,cust3));

        Mockito.when(customerService.getCustomers()).thenReturn(customers);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    public void getCustomerSuccess() throws Exception {
////        MockitoAnnotations.initMocks(this);
//        MockitoAnnotations.openMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(customerRestController).build();

        Mockito.when(customerService.getCustomer(cust1.getId())).thenReturn(cust1);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/customers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.lastName",is("doe")));
    }

    @Test
    public void getCustomerNotFound() throws Exception {

        try{
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/customers/100")
                            .contentType(MediaType.APPLICATION_JSON));
        }catch(Exception e){
            boolean isContains = e.getMessage().contains("Customer id not found - 100");
            assertTrue(isContains);
        }

    }

    @Test
    public void addCustomerSuccess() throws Exception {
////        MockitoAnnotations.initMocks(this);
//        MockitoAnnotations.openMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(customerRestController).build();

//        Customer tempCustomer = Customer.builder()
//                .id(4)
//                .firstName("firstName")
//                .lastName("lastName")
//                .email("first@gmail.com")
//                .build();

        Customer tempCustomer = new Customer(4,"firstName","lastName","first@gmail.com");


        Mockito.when(customerService.saveCustomer(tempCustomer)).thenReturn(tempCustomer);

        String content = objectWriter.writeValueAsString(tempCustomer);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.firstName",is("firstName")));


    }

    @Test
    public void addCustomerError() throws Exception {
////        MockitoAnnotations.initMocks(this);
//        MockitoAnnotations.openMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(customerRestController).build();

//        Customer tempCustomer = Customer.builder()
//                .id(4)
//                .firstName("firstName")
//                .lastName("lastName")
//                .email("first@gmail.com")
//                .build();

        Customer tempCustomer = new Customer("firstName","lastName","first@gmail.com");


        Mockito.when(customerService.saveCustomer(tempCustomer)).thenReturn(tempCustomer);

        String content = objectWriter.writeValueAsString(tempCustomer);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isNotFound());


    }

    @Test
    public void updateCustomerSuccess() throws Exception {
////        MockitoAnnotations.initMocks(this);
//        MockitoAnnotations.openMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(customerRestController).build();

        Customer tempCustomer = new Customer(1,"john","doe","john@gmail.com");

        Mockito.when(customerService.getCustomer(cust1.getId())).thenReturn(cust1);
        Mockito.when(customerService.saveCustomer(tempCustomer)).thenReturn(tempCustomer);

        String content = objectWriter.writeValueAsString(tempCustomer);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.email",is("john@gmail.com")));

    }

    @Test
    public void deleteCustomerSuccess() throws Exception {
//        MockitoAnnotations.openMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(customerRestController).build();

        Mockito.when(customerService.getCustomer(cust2.getId())).thenReturn(cust2);

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/customers/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void deleteCustomerBadRequest() throws Exception {

        Mockito.when(customerService.getCustomer(cust2.getId())).thenReturn(cust2);

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/customers/abc")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteCustomerNotFound() throws Exception {

        try{
            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/api/customers/100")
                            .contentType(MediaType.APPLICATION_JSON));

        }catch(Exception e){
            boolean exception = e.getMessage().contains("Customer id not found - 100");
            assertTrue(exception);
        }


    }
}
