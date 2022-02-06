package rest.spring_mvc_hiber_aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.spring_mvc_hiber_aop.dao.EmployeeDAO;
import rest.spring_mvc_hiber_aop.entity.Employee;

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
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDAO.deleteById(id);
    }


}
