package com.chethan.controller;

import com.chethan.exception.CustomerNotFoundException;
import com.chethan.model.Customer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chethanshetty on 11/02/17.
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {

    private static List<Customer> customerList = new ArrayList<Customer>();

    static {
        customerList.add(new Customer(1l, "Adam"));
        customerList.add(new Customer(2l, "Bryan"));
        customerList.add(new Customer(3l, "Elon"));
        customerList.add(new Customer(4l, "Steve"));
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Customer> allCustomers() {
        return customerList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    void deleteCustomer(@PathVariable("id") Long id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                customerList.remove(customer);
                break;
            }
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Customer getCustomerWithID(@PathVariable("id") Long id) {
        Customer expectedCustomer = null;

        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                expectedCustomer = customer;
            }
        }

        if (expectedCustomer == null) {
            throw new CustomerNotFoundException();
        }

        return expectedCustomer;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addCustomer(@RequestBody Customer customer) {
        customerList.add(customer);
    }
}
