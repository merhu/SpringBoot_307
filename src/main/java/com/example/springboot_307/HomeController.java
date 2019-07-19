package com.example.springboot_307;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
@Autowired
    EmployeeRepository employeeRepository;

@RequestMapping("/")
    public String index(Model model){
    Employee employee = new Employee();
    employee.setName ( "Stepehn Bullock" );
    employee.setSsn("656-76-1234");

    //laptop

    Laptop laptop = new Laptop ();
    laptop.setBrand ( "Dell" );
    laptop.setModel ( "Latitude XL" );

    //ADD THE LAPTOP TO THE EMPLOYEE
    employee.setLaptop(laptop);

    //save the employee to the database

    employeeRepository.save ( employee );

    //GRAB ALL THE EMPLOYEES FROM THE DATABASE AND SEND THEM TO THE TEMPLATE
    model.addAttribute ( "employees", employeeRepository.findAll () );
    return "index";
}
}
