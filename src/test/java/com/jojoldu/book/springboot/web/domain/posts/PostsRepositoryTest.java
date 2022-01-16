package com.jojoldu.book.springboot.web.domain.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest //H2데이터데이터베이스 자동실행.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // Junit 단위 테스트가 끝날때마다 수행되는 메소드 지정, 테스트간 침범 방지.
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void save_load_text(){
        //given
        String title = "test text";
        String content = "test content";

        //postsRepository : posts에 insert/update 쿼리실행.
        postsRepository.save(Posts.builder().title(title).content(content).author("preciosa0816@gmail.com").build());

        //when
        List<Posts> postsList = postsRepository.findAll(); //findAll : 테이블 posts에 있는 모든 데이터 조회.

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
