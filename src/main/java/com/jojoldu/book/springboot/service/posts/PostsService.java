package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor //bean 주입. final이 선언된 모든 필드를 인자값으로 하는 생성자를 주입함.
                         // 해당클래스의 의존성 관계가 변경될때마다 생성자코드를 계속해서 수정하는 번거로움 해결.
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        // jpa의 영속성컨텍스트로 인해 update쿼리를 날리지 않음.
        // 영속성 컨텍스트 : 엔티티를 영구저장하는 환경.
        // jpa의 엔티티매니저가 활성화된 상태로 트랜잭션 안에서 데이터베이스에서 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태이며
        // 이상태에서 데이터값 변경시 랜잭션이 끝나는 시점에 해당 테이블에 변경분 반영ㅎㅁ.
        // => Entity 객체의 값 변경시 별도로 update 쿼리를 날릴 필요가 없다 = 더티체킹
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
