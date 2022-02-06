package rest.spring_mvc_hiber_aop.service;

import rest.spring_mvc_hiber_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee save(Employee employee);

    Employee getEmployee(Long id);

    void deleteEmployee(Long id);
}
