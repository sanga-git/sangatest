package com.victolee.board.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victolee.board.domain.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long>{
	Optional<MemberEntity> findByEmail(String userEmail);
	//email where 조건절로하여, 데이터를 가져올수 있도록 설정 
}
