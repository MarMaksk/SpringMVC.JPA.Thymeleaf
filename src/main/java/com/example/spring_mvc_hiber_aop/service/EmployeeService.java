package com.example.spring_mvc_hiber_aop.service;

import com.example.spring_mvc_hiber_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void save(Employee employee);

    Employee findById(Long id);
}
