package com.example.spring_mvc_hiber_aop.dao;

import com.example.spring_mvc_hiber_aop.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    Employee save(Employee employee);
}
