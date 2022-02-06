package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //lombok annotation //Entity 클래스에서는 절대 setter 메소드 x(builder를 사용해서 명확하게 필드지정후 db삽입)
@NoArgsConstructor //lombok annotation, 기본 생성자 자동추가, public Posts(){} 와 동일 효과
@Entity //JPA annotation, table 과 링크될 클래스임을 표시함.
public class Posts extends BaseTimeEntity { //BaseTimeEntity를 상속시 수정/등록시간이 자동으로 저장됨.
   @Id //PK
   @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 생성규칙
   private Long id;

   @Column(length = 500, nullable = false)//column 없어도 컬럼으로 선언되지만 기본값 변경시 사용
   private String title;

   @Column(columnDefinition = "TEXT", nullable = false)
   private String content;

   private String author;

   @Column(columnDefinition = "TEXT", nullable = true)
   private String test;

   @Builder //빌더패턴클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author, String test){
       this.title=title;
       this.content=content;
       this.author=author;
       this.test=test;
   }

   public void update(String title, String content){
      this.title=title;
      this.content=content;
   }
}
