package com.victolee.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

	
	 ADMIN("ROLE_ADMIN"),
	 MEMBER("ROLE_MEMBER");
	
	private String value;
	
	//service에서 사용하는 enum 객체
}
