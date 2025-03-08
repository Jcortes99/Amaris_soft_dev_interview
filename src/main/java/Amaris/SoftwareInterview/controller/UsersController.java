package Amaris.SoftwareInterview.controller;

import Amaris.SoftwareInterview.model.User;
import Amaris.SoftwareInterview.service.GetDataService;
import Amaris.SoftwareInterview.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.concurrent.CompletionException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Users")
public class UsersController {

    private final GetDataService getDataService;
    private final UserService userService;
    public UsersController(GetDataService getDataService, UserService userService) {
        this.getDataService = getDataService;
        this.userService = userService;
    }

    @GetMapping("/get-user/{id}")
    public CompletableFuture<String> getUserById(@PathVariable int id){
        String url = "http://dummy.restapiexample.com/api/v1/employee/" + id;
        ObjectMapper objectMapper = new ObjectMapper();
        return getDataService.fetchData(url)
                .thenApply(response -> {
                    try {
                        JsonNode jsonNode = objectMapper.readTree(response);
                        return jsonNode.get("data").toString();
                    } catch (Exception e) {
                        return "Invalid response: " + response;
                    }
                });
    }
    @GetMapping("/get-user")
    public CompletableFuture<String> getAllUsers(){
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        ObjectMapper objectMapper = new ObjectMapper();
        return getDataService.fetchData(url)
                .thenApply(response -> {
                    try {
                        JsonNode jsonNode = objectMapper.readTree(response);
                        return jsonNode.get("data").toString();
                    } catch (Exception e) {
                        return "Invalid response: " + response;
                    }
                });
    }
    @GetMapping("/get-all-names")
    public CompletableFuture<String> getAllNames(){
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        ObjectMapper objectMapper = new ObjectMapper();
        return getDataService.fetchData(url)
                .thenApply(response -> {
                    try {
                        JsonNode jsonNode = objectMapper.readTree(response);
                        return jsonNode.get("data").toString();
                    } catch (Exception e) {
                        return "Invalid response: " + response;
                    }
                });
    }
    @GetMapping("/get-anual-salary/{id}")
    public CompletableFuture<User> getAnualSalary(@PathVariable int id) {
        String url = "http://dummy.restapiexample.com/api/v1/employee/" + id;
        ObjectMapper objectMapper = new ObjectMapper();

        return getDataService.fetchData(url)
                .thenApply(response -> {
                    try {
                        JsonNode jsonNode = objectMapper.readTree(response);
                        JsonNode dataNode = jsonNode.get("data");

                        if (dataNode == null || dataNode.isNull()) {
                            throw new CompletionException(new RuntimeException("User not found"));
                        }

                        User user = new User(
                                dataNode.get("id").asInt(),
                                dataNode.get("employee_name").asText(),
                                dataNode.get("employee_salary").asLong(),
                                dataNode.get("employee_age").asInt()
                        );

                        return userService.calculate_anual_salary(user);

                    } catch (Exception e) {
                        throw new CompletionException(new RuntimeException("Error parsing response", e));
                    }
                });
    }
}
