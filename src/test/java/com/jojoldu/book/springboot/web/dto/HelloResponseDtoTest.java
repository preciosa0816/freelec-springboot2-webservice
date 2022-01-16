package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
// assertj의 검증메소드 , 메소드 체이닝 지원 : junit과 달리 CoreMatchers 라이브러리 불필요, 자동완성 확실히 지원
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {

    @Test
    public void lombok_test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
