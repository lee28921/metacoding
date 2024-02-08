package com.tenco.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.blog.entity.Board;

@Mapper
public interface BoardMapper {
	
	public void insert(Board board);
	public List<Board> readAll();
	public Board readByNo(Long no);
	public void update(Board board);
	public int delete(Long no);
}
