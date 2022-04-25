package com.example.service;

import com.example.entity.Customer;
import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer theCustomer);
    List<Customer> getCustomers();
    Customer getCustomer(int theId);
    void deleteCustomer(int theId);
}
