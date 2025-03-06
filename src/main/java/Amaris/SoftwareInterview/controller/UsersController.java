package Amaris.SoftwareInterview.controller;

import Amaris.SoftwareInterview.service.GetDataService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

@RestController
@RequestMapping("/Users")
public class UsersController {

    private final GetDataService getDataService;
    public UsersController(GetDataService getDataService) {
        this.getDataService = getDataService;
    }

//    @GetMapping("/get-all-data")
//    public CompletableFuture<String> getData(){
//        String url = "http://dummy.restapiexample.com/api/v1/employees";
//        return getDataService.fetchData(url);
//    }

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
                        List<String> employeeNames = new ArrayList<>();
                        JsonNode list = jsonNode.get("data");
                        for (JsonNode node : list) {
                            employeeNames.add(node.get("employee_name").asText());
                        }
                        return employeeNames.toString();
                    } catch (Exception e) {
                        return "Invalid response: " + response;
                    }
                });
    }
}
