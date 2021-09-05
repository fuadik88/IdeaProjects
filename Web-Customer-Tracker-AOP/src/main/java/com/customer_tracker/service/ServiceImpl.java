package com.customer_tracker.service;

import com.customer_tracker.dao.CustomerDAO;
import com.customer_tracker.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceImpl implements CustomerService{
    @Autowired
    private CustomerDAO customerDAO;
    //private final CustomerDAO customerDAO = new CustomerList(); //Injecting this above, with annotation

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }


    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(Customer customer) {
        customerDAO.deleteCustomer(customer);
    }
}
