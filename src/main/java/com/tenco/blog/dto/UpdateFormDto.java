package com.tenco.blog.dto;

import lombok.Data;

@Data
public class UpdateFormDto {
	
	private Long no;
	private String title;
	private String content;
	private String author;
}
