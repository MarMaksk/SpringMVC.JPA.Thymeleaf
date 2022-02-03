package com.example.spring_mvc_hiber_aop.service;

import com.example.spring_mvc_hiber_aop.dao.EmployeeDAO;
import com.example.spring_mvc_hiber_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmplyoeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeDAO.getById(id);
    }
}
