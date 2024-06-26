package com.mycompany.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(
        basePackages = "com.mycompany.clients"
)
@SpringBootApplication(
        scanBasePackages = {
                "com.mycompany.amqp",
                "com.mycompany.customer"
        }
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
