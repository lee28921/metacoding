package com.tenco.blog.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.tenco.blog.dto.SaveFormDto;
import com.tenco.blog.dto.UpdateFormDto;
import com.tenco.blog.entity.Board;
import com.tenco.blog.handler.MyResfulExceptionHandler;
import com.tenco.blog.handler.exception.CustomRestfulException;
import com.tenco.blog.service.BoardService;
import com.tenco.blog.utils.Define;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
    @GetMapping("/")
    public String index(Model model) {
    	
    	List<Board> list = boardService.readBoardList();
    	model.addAttribute("BoardList",list);
    	
        return "index";
    }

    // 주소 : http://localhost:8080/board/save
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
    
    @PostMapping("/board/save")
    public String save(SaveFormDto dto){
    	
    	if(dto.getAuthor() == null || dto.getAuthor().isEmpty()) {
    		throw new CustomRestfulException(Define.NO_USERNAME, HttpStatus.BAD_REQUEST);
    	}
    	if(dto.getTitle() == null || dto.getTitle().isEmpty()) {
    		throw new CustomRestfulException(Define.NO_TITLE, HttpStatus.BAD_REQUEST);
    	}
    	if(dto.getContent() == null || dto.getContent().isEmpty()) {
    		throw new CustomRestfulException(Define.NO_CONTENT, HttpStatus.BAD_REQUEST);
    	}
    	
    	boardService.createBoard(dto);
    	
        return "redirect:/";
    }
    
    // http://localhost:8080/board/{no}/updateForm
    @GetMapping("/board/{no}/updateForm")
    public String updateForm(@PathVariable("no") Long no, Model model) {
    	log.info("no: "+no);
    	
    	Board board = boardService.readBoard(no);
    	model.addAttribute("board", board);
    	
        return "board/updateForm";
    }
    
    @PostMapping("/board/{no}/update")
    public String update(@PathVariable("no") Long no, UpdateFormDto dto){
    	
    	if(dto.getTitle() == null || dto.getTitle().isEmpty()) {
    		throw new CustomRestfulException(Define.NO_TITLE, HttpStatus.BAD_REQUEST);
    	}
    	if(dto.getContent() == null || dto.getContent().isEmpty()) {
    		throw new CustomRestfulException(Define.NO_CONTENT, HttpStatus.BAD_REQUEST);
    	}
    	
    	boardService.modifyBoard(dto, no);
        return "redirect:/";
    }

    @PostMapping("/board/{no}/delete")
    public String delete(@PathVariable("no") Long no){
    	
    	boardService.deleteBoard(no);
    	
        return "redirect:/";
    }
}
