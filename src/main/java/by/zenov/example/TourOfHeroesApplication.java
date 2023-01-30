package by.zenov.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class TourOfHeroesApplication {
    public static void main(String[] args) {
        Environment environment = SpringApplication.run(TourOfHeroesApplication.class, args).getEnvironment();
        String baseUrl = "http://localhost:" + environment.getProperty("server.port");
        log.info("""
                    \n-----------------------------------------------------------------------------
                    Application '{}' is running! Base URL:   {}
                    -----------------------------------------------------------------------------""",
                environment.getProperty("spring.application.name"),
                baseUrl
        );
    }
}