package edus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "edus.repositories")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
