package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json 반환
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        //@RequestParam : 외부에서 api로 넘긴 파라미터를 가져오는 어노테이션
        return new HelloResponseDto(name,amount);
    }
}
