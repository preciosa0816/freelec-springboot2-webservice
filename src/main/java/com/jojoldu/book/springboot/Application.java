package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //jpa auditing 활성화
@SpringBootApplication //여기부터 설정읽어감, 최상단 위치해야함.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); //내장 WAS실행.]//http://localhost:8080/h2-console

    }
}
