package com.customer_tracker.service;

import com.customer_tracker.entity.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(Customer customer);
}
