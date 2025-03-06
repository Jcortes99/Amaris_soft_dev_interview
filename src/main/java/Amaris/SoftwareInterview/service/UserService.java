package Amaris.SoftwareInterview.service;

import Amaris.SoftwareInterview.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String calculate_anual_salary(User user){
        Long employee_anual_salary = user.getEmployee_salary() * 12;
        user.setEmployee_anual_salary(employee_anual_salary);
        return "The anual salary for " + user.getName() + " is: " + employee_anual_salary;
    }
}
