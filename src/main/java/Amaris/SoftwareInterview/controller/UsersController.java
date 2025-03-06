package Amaris.SoftwareInterview.controller;

import Amaris.SoftwareInterview.service.GetDataService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/Users")
public class UsersController {

    private final GetDataService getDataService;
    public UsersController(GetDataService getDataService) {
        this.getDataService = getDataService;
    }
    @PostMapping("/add-user")
    public String addUser(){
        return "user added";
    }

    @GetMapping("/get-all-data")
    public CompletableFuture<ResponseEntity<String>> getData(){
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        return getDataService.getAllData(url).thenApply(ResponseEntity::ok);
    }

    @GetMapping("/get-user/{id}")
    public CompletableFuture<String> getData1(@PathVariable int id){
        String url = "http://dummy.restapiexample.com/api/v1/employee/" + id;
        return getDataService.getAllData(url);
    }
}
