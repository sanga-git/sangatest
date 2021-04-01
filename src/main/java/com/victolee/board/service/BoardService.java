package com.victolee.board.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.victolee.board.domain.entity.BoardEntity;
import com.victolee.board.domain.repository.BoardRepository;
import com.victolee.board.dto.BoardDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {

	//@AllArgsConstructor : repository를 자동주입하기 위해사용 
	private BoardRepository boardRepository;
	
	@Transactional
	public Long savePost(BoardDto boardDto) {
		return boardRepository.save(boardDto.toEntity()).getId();
		
		//매개변수로 entity전달
		
	}

	@Transactional
	public List<BoardEntity> getBoardlist() {
		List<BoardEntity> boardEntities=boardRepository.findAll();
		//List<BoardDto> boardDtoList=new ArrayList<>();
		
		System.out.println(boardEntities);
		/*
		 * for(BoardEntity boardEntity:boardEntities) { BoardDto
		 * boardDTO=BoardDto.builder() .id(boardEntity.getId())
		 * .title(boardEntity.getTitle()) .content(boardEntity.getContent())
		 * .writer(boardEntity.getWriter())
		 * 
		 * .build(); }
		 * 
		 * System.out.println(boardDtoList);
		 */
		
		
		return boardEntities;
	}

	@Transactional
	public BoardEntity getPost(Long id) {
		 BoardEntity boardEntity=boardRepository.findById(id).get();
		 System.out.println(boardEntity);
		
		return boardEntity;
	}

	@Transactional
	public BoardEntity updatePost(BoardEntity boardEntity, Long id) {
		
		return boardRepository.save(boardEntity);
	}

	public void deletePost(Long id) {
		
		BoardEntity boardEntity=boardRepository.findById(id).get();
		
		boardRepository.delete(boardEntity);
		
	
		
	}

	

	
	



}
