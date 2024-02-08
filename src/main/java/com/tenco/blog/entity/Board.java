package com.tenco.blog.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Board {
	
	private Long no;
	private String title;
	private String content;
	private String username;
	private Timestamp rdate;
}
