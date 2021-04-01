package com.victolee.board.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimeEntity {
	
	//데이터 조작시 자동으로 날짜를 수정해주는 jpa의 auditing 기능사용
	
	//@MappedSuperclass : 테이블로 매핑하지않고, 자식클래스에게 매핑정보를 상속하기 위한 어노테이션
	//@EntityListeners(AuditingEntityListener.class)  : 시간에 대해서 자동으로 값을 넣어줄수 있도록 하는것 
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createDate;
	
	
	//@CreatedDate : entity가 처음 저장될때 생성일을 주입하는 어노테이션,생성일은 update할필요가 없으므로 false로 놔둔다.(속성을 추가하지않으면 null이되버린다)
	
	
	//	@LastModifiedDate:Entity가 수정될때 수정일자를 주입하는 어노테이션입니다.
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
	

}
