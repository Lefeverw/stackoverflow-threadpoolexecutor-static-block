package com.wouterlefever.stackoverflow;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        IntStream.range(0, 100)
                .parallel()
                .forEach(i -> {
                    ThreadPoolTaskExecutorSingleton.getInstance().submit(() -> System.out.println("Execution of API call " + i));
                });
    }
}