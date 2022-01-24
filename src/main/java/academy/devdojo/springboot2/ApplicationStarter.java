package academy.devdojo.springboot2;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class ApplicationStarter {
  
  public static void main(String[] args) {
    SpringApplication.run(ApplicationStarter.class, args);
  }
  
}
