package br.com.fiap.postechfastfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "br.com.fiap.postechfastfood",
        "br.com.fiap.postechfastfood.infrastructure.web.api",
        "br.com.fiap.postechfastfood.infrastructure.persistence.jpa"

})
public class PostechFastfoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostechFastfoodApplication.class, args);
    }

}
