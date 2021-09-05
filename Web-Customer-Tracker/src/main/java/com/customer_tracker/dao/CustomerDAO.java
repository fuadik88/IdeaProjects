package com.customer_tracker.dao;

import com.customer_tracker.entity.Customer;
import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(Customer customer);
}
