package br.com.fiap.postechfastfood_old;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "br.com.fiap.postechfastfood_old",
        "br.com.fiap.postechfastfood_old.infrastructure.web.api",
        "br.com.fiap.postechfastfood_old.infrastructure.persistence.jpa"

})
public class PostechFastfoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostechFastfoodApplication.class, args);
    }

}
