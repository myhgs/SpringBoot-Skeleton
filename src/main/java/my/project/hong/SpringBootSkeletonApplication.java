package my.project.hong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootSkeletonApplication {

    public static void main(String[] args){
        SpringApplication.run(SpringBootSkeletonApplication.class, args);
    }

}
