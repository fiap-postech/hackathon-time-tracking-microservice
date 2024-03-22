package br.com.fiap.hackathon.time.tracking.launcher;

import br.com.fiap.hackathon.time.tracking.driven.mongo.repository.TimeTrackingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {TimeTrackingRepository.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
