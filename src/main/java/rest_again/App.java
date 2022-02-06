package rest_again;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import rest_again.entity.Employee;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        Communication communication = context.getBean(Communication.class);
        List<Employee> employees = communication.showAllEmployees();
        System.out.println(employees);
    }
}
