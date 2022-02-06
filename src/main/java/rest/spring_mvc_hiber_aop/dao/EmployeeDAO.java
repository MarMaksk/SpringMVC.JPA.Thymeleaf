package rest.spring_mvc_hiber_aop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import rest.spring_mvc_hiber_aop.entity.Employee;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    Employee save(Employee employee);

    void deleteById(Long id);
}
