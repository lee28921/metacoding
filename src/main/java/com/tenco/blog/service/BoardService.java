package com.tenco.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
import com.tenco.blog.dto.SaveFormDto;
import com.tenco.blog.dto.UpdateFormDto;
import com.tenco.blog.entity.Board;
import com.tenco.blog.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Transactional
	public void createBoard(SaveFormDto dto) {
		
		Board board = Board.builder()
							.title(dto.getTitle())
							.content(dto.getContent())
							.username(dto.getAuthor())
							.build();
		
		mapper.insert(board);
	}
	
	public List<Board> readBoardList() {
		
		return mapper.readAll();
	}
	public Board readBoard(Long no) {
		return mapper.readByNo(no);
	}
	public void modifyBoard(UpdateFormDto dto, Long no) {
		
		Board board = Board.builder()
				.no(no)
				.title(dto.getTitle())
				.content(dto.getContent())
				.username(dto.getAuthor())
				.build();
		
		mapper.update(board);
	}
	
	public void deleteBoard(Long no) {
		mapper.delete(no);
	}
}
