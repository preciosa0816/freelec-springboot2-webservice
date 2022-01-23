package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //jpa Entity클래스들이 BaseTimeEntity를 상속할경우 필드도 칼럼으로 인식하도록함.
@EntityListeners(AuditingEntityListener.class) //클래스에 Auditing기능 포함(단순반복적인 코드 처리)
public class BaseTimeEntity {//모든 entity들의 상위 클래스로 엔티티들의 createdDate, modifiedDate 자동관리

    @CreatedDate //Entity가 생성되어 저장될때 시간 자동저장됨.
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 entity의 값 변경시 시간 자동저장함.
    private LocalDateTime modifiedDate;

}
