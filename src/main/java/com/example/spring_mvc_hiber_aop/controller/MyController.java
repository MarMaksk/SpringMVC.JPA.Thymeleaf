package com.example.spring_mvc_hiber_aop.controller;

import com.example.spring_mvc_hiber_aop.entity.Employee;
import com.example.spring_mvc_hiber_aop.service.EmplyoeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contr")
public class MyController {
    @Autowired
    private EmplyoeeServiceImpl employeeSerivce;

    @RequestMapping("/show")
    public String showAllEmployees(Model model) {
        model.addAttribute("emps", employeeSerivce.getAllEmployees());
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        model.addAttribute("emp", new Employee());
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("emp") Employee employee) {
        employeeSerivce.save(employee);
        return "redirect:/contr/show";
    }

    @RequestMapping("/updateInfo/{id}")
    public String updateEmployee(@RequestParam Long id, Model model) {
        model.addAttribute("emp", employeeSerivce.findById(id));
        return "employee-info";
    }
}
