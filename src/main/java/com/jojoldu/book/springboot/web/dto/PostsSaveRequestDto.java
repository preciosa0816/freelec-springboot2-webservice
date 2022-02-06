package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {// Entity클래스와 유사한 형태. Entity 클래스를 Request/Response클래스로 사용x.
                                  //view 를 위한 클래스로 request/response용 클래스인 dto생성.
    private String title;
    private String content;
    private String author;

    private String test;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author, String test){
        this.title=title;
        this.content=content;
        this.author=author;
        this.test=test;
    }

    public Posts toEntity(){
        return Posts.builder().title(title).content(content).author(author).test(test).build();
    }
}
