package com.victolee.board.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Data
@Getter
@Table
public class BoardEntity {
	
	//@NoArgsConstructor(access = AccessLevel.PROTECTED)
	/*
	 * 파라미터가 없는 기본 생성자를 추가하는 어노테이션입니다. ( JPA 사용을위해 기본 생성자 생성은 필수 ) access는 생성자의 접근
	 * 권한을 설정하는 속성이며, 최종적으로 protected BoardEntity() { }와 동일합니다. protected인 이유는
	 * Entity 생성을 외부에서 할 필요가 없기 때문입니다.
	 */
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * @GeneratedValue(strategy= GenerationType.IDENTITY) 기본키로 대체키를 사용할 때, 기본키 값 생성
	 * 전략을 명시합니다. ( 참고 )
	 */
	
	
	@Column(length = 10, nullable = true)
	private String writer;
	
	@Column(columnDefinition = "TEXT" ,nullable = true)
	private String title;
	
	
	@Column(columnDefinition = "TEXT",nullable = true)
	private String content;
	
	
	
	@Builder
	public BoardEntity(Long id, String title, String content, String writer) {
		this.id=id;
		this.title=title;
		this.content=content;
		this.writer=writer;
	}
	
	
	/*
	 * @Builder 빌더패턴 클래스를 생성해주는 어노테이션입니다.
	 * 
	 * @Setter 사용 대신 빌더패턴을 사용해야 안정성을 보장할 수 있습니다.
	 */
}
