package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)//스프링부트테스트와 JUnit 사이에 연결자역할
@WebMvcTest(controllers = HelloController.class)//Web집중. @service,@Component, @Repository 사용 x
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc; //web API test.

    @Test
    public void return_hello() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")) //chaining support
                .andExpect(status().isOk()) // result check, Http header status(200,404,500), 200 or not
                .andExpect(content().string(hello)); //testify result.
    }

}
