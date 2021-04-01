package com.victolee.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victolee.board.domain.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{

}
