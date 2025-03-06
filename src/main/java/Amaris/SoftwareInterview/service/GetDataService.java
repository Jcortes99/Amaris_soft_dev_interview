package Amaris.SoftwareInterview.service;

import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;

@Service
public class GetDataService {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers;
    public GetDataService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
        this.headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:123.0) Gecko/20100101 Firefox/123.0");
        headers.set("Accept", "application/json, text/plain, */*");
        headers.set("Accept-Language", "en-US,en;q=0.5");
        headers.set("Connection", "keep-alive");
        headers.set("Cookie", "humans_21909=1");
    }
    @Async
    public CompletableFuture<String> fetchData(String url){

        try {

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            String responseBody = response.getBody();
            if (responseBody != null && responseBody.trim().startsWith("{")) {
                return CompletableFuture.completedFuture(responseBody);
            } else {
                return CompletableFuture.completedFuture("Error: Empty response");
            }

        } catch (Exception e) {
            return CompletableFuture.completedFuture("Error fetching data: " + e.getMessage());
        }
    }
}
