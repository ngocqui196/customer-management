package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customers;

    static {

        customers = new ArrayList<>();
        customers.add( new Customer(1, "John", "john@com.codegym.vn", "Hanoi"));
        customers.add( new Customer(2, "Bill", "bill@com.codegym.vn", "Danang"));
        customers.add( new Customer(3, "Alex", "alex@com.codegym.vn", "Saigon"));
        customers.add(new Customer(4, "Adam", "adam@com.codegym.vn", "Beijin"));
        customers.add( new Customer(5, "Sophia", "sophia@com.codegym.vn", "Miami"));
        customers.add( new Customer(6, "Rose", "rose@com.codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void save(int id,Customer customer) {

        customers.add( id,customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }



    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
