CREATE DATABASE `metacoding`;

# 유저 테이블
CREATE TABLE `user_tb` (
	`uid`		bigint AUTO_INCREMENT PRIMARY KEY,
	`username` 	varchar(20) UNIQUE,
	`password`	varchar(50),
	`nickname`	varchar(20),
	`rdate`		timestamp DEFAULT now()
);

# 게시글 테이블
CREATE TABLE `board_tb` (
	`no`		bigint AUTO_INCREMENT PRIMARY KEY,
	`title` 	varchar(20),
	`content` 	varchar(255),
	`username` 	varchar(20),
	`rdate` 	timestamp DEFAULT now()
);
DROP TABLE board_tb;
-- 테스트 코딩

# board

INSERT INTO board_tb (title,content,username,rdate) VALUES ('제목1','내용1','관리자',now());

SELECT * FROM board_tb;

SELECT * FROM board_tb WHERE `no`=1;

UPDATE board_tb SET `title`='변경된 제목', `content`='변경된 내용' WHERE `no`=2;

DELETE FROM board_tb WHERE `no`=3;