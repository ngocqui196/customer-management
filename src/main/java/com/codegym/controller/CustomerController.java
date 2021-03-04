package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping
    public String index(Model model) {
        List customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "index";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create","customer",new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView addCustomer(@ModelAttribute("customer") Customer customer) {
        int code = (int) Math.floor(((Math.random() * 99999)));
        customer.setId(code);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("mess","Đã thêm thành công!!!");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id, @ModelAttribute Customer customer) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editCustomer(@ModelAttribute Customer customer) {
        customerService.update(customer.getId(),customer);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message","Sửa thành công ${customer} !!!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showViewDelete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteCustomer(@ModelAttribute Customer customer) {
        customerService.remove(customer.getId());
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("mess","Đã xoá thành công");
        return modelAndView;
    }
}
