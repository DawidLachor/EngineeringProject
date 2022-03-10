package pl.skorpjdk.engineeringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EngineeringProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EngineeringProjectApplication.class, args);
    }

}
