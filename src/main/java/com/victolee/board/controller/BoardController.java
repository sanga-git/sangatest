package com.victolee.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victolee.board.domain.entity.BoardEntity;
import com.victolee.board.dto.BoardDto;
import com.victolee.board.service.BoardService;


import lombok.AllArgsConstructor;



@Controller
@AllArgsConstructor
public class BoardController {
	
	//url을 매핑하고 비즈니스 로직함수를 호출하여 view에 뿌려주는 역할을 하는 컨트롤러 구현
	//@AllArgsConstructor 빈 주입방식과 관련, 생성자로 bean 객체를 받는 방식을 해결해주는 어노테이션, @atuowired를 쓰지않아도 됩니다 
	//@RestController도 존재하는데, 이는 @Controller, @ResponseBody가 합쳐진 어노테이션입니다.
	///view 페이지가 필요없는 API 응답에 어울리는 어노테이션입니다.
	

	
	private BoardService boardService;
	
	//게시글 목록
	@GetMapping("/list")
	public String list(Model model ) {
		List<BoardEntity> boardList = boardService.getBoardlist();
		model.addAttribute("boardList",boardList);
		System.out.println(boardList+"!!!!!!!!!!!!!!!!!!");
		return "board/list";
	}
	
	@GetMapping("/post")
	public String write() {
		return "board/write.html";	
	}
	
	@PostMapping("/post")
	public String write(BoardDto boardDto) {
		boardService.savePost(boardDto);
		
		return "redirect:/";
	}
	
	//게시글 상세조회 페이지
	@GetMapping("/post/{id}")
	public String detail(@PathVariable Long id,Model model) {
		
		BoardEntity boardEntity=boardService.getPost(id);
		model.addAttribute("boardEntity",boardEntity);
		System.out.println(boardEntity);
		return "board/detail.html";
		
	}
	
	
	//게시글 수정페이지
	@GetMapping("/post/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		BoardEntity boardEntity=boardService.getPost(id);
		model.addAttribute("boardEntity",boardEntity);
		return "board/update.html";
	}
	
	//게시글 수정
	@PutMapping("/post/edit/{id}")
	public String update(@PathVariable Long id,BoardEntity boardEntity) {
		BoardEntity update=boardService.updatePost(boardEntity,id);
		
		   return "redirect:/";
	}
	
	
	//게시글 삭제
	@DeleteMapping("/post/{id}")
	public String delete(@PathVariable Long id) {
		boardService.deletePost(id);
		 return "redirect:/";
	}
	

	 
}