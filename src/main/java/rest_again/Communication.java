package rest_again;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import rest_again.entity.Employee;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/rest/show";

    public List<Employee> showAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {
                        });
        return responseEntity.getBody();
    }

    public Employee getEmployee(long id) {
        return restTemplate.getForObject(URL + "/" + "id", Employee.class);
    }

    public void saveEmployee(Employee employee) {
        long id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("new Employees was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee id " + id + " was updated");
        }
    }

    public void deleteEmployee(long id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee was deleted");
    }

}
