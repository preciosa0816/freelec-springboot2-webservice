package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // JpaRepository : CRUD 기본생성.
    // entity 와 Entity Repository 는 함께 움직여야함.
}
