package Amaris.SoftwareInterview.service;

import Amaris.SoftwareInterview.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    @Test
    void testCalculateAnualSalary(){
        UserService userService = new UserService();
        User user = new User(1, "George", 3800L,  41);
        assertEquals(45600L, userService.calculate_anual_salary(user).getEmployee_anual_salary());
    }
}