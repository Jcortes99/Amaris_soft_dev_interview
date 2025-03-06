package Amaris.SoftwareInterview.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FaviconController {
    @GetMapping("/favicon.ico")
    public ResponseEntity<Void> returnNoFavicon() {
        return ResponseEntity.notFound().build();
    }
}
