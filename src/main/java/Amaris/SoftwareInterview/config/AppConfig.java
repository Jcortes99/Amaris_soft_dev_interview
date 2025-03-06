package Amaris.SoftwareInterview.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
//    public WebClient webClient() {
//        return WebClient.builder()
//                .defaultHeader("User-Agent", "Mozilla/5.0")
//                .defaultHeader("Accept", "application/json")
//                .build();
//    }
}

