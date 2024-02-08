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
public class User {
	
	private Long uid;
	private String username;
	private String passward;
	private String nickname;
	private Timestamp rdate;
}
