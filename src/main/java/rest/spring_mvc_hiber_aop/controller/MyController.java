package rest.spring_mvc_hiber_aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.spring_mvc_hiber_aop.entity.Employee;
import rest.spring_mvc_hiber_aop.exeption_handling.EmployeeIncorrectData;
import rest.spring_mvc_hiber_aop.exeption_handling.NoSuchEmployeeExeption;
import rest.spring_mvc_hiber_aop.service.EmplyoeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MyController {
    @Autowired
    private EmplyoeeServiceImpl employeeSerivce;

    @RequestMapping("/show")
    public List<Employee> showAllEmployees() {
        return employeeSerivce.getAllEmployees();
    }

    @RequestMapping("/employee")
    public Employee getEmployee(@RequestParam Long id) {
        Employee employee = employeeSerivce.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeExeption("There is no employee with ID = "
                    + id + " long Database");
        }
        return employee;
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeExeption exeption) {
        EmployeeIncorrectData empInc = new EmployeeIncorrectData();
        empInc.setInfo(exeption.getMessage());
        return new ResponseEntity<>(empInc, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exeption) {
        EmployeeIncorrectData empInc = new EmployeeIncorrectData();
        empInc.setInfo(exeption.getMessage());
        return new ResponseEntity<>(empInc, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeSerivce.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeSerivce.save(employee);
    }

    @DeleteMapping("/empdel")
    public String deleteEmployee(@RequestParam long id) {
        Employee employee = employeeSerivce.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeExeption("There is no employee with ID " +
                    id + " in Database");
        }
        employeeSerivce.deleteEmployee(id);
        return "Employee delete";
    }
}
