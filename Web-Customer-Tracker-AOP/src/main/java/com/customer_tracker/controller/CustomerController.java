package com.customer_tracker.controller;

import com.customer_tracker.entity.Customer;
import com.customer_tracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired          //it can detect it using @Service annotation, just like @Component
    private CustomerService customerService;

    @GetMapping("/list")
    String listCustomers(Model model){
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customerlist";
    }

    @GetMapping("/addCustomer")
    String addCustomer(Model model){
        model.addAttribute("newcustomer", new Customer());
        return "addcustomer";
    }

    @PostMapping("/saveCustomer")
    String saveCustomer(@Valid @ModelAttribute("newcustomer") Customer customer, BindingResult result){
        if(result.hasErrors())
            return "addcustomer";
        else {
            customerService.saveCustomer(customer);
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/updateForm")
    String updateCustomer(@RequestParam("id") int id, Model model){
        //get customer from our customer service (hence, >customerDAO>Database)
        Customer customer = customerService.getCustomer(id);
        //add customer to model attribute to pre-populate the html form
        model.addAttribute("newcustomer", customer); //model name should be same as above methods
        //send over to our form                                  //because we are populating the same form
        return "addcustomer";                                   //that used to add customer
    }

    @GetMapping("/deleteCustomer")
    String deleteCustomer(@RequestParam("id") int id, Model model){
        Customer customer = customerService.getCustomer(id);
        customerService.deleteCustomer(customer);
        return "redirect:/customer/list";
    }
}
