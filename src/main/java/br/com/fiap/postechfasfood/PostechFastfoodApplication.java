package br.com.fiap.postechfasfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {
//        "br.com.fiap.postechfastfood",
//        "br.com.fiap.postechfastfood.apis",
//        "br.com.fiap.postechfastfood.externals"
//})
@SpringBootApplication
public class PostechFastfoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostechFastfoodApplication.class, args);
    }
}
