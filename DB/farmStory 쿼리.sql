#내용 : FarmStory 프로젝트 테이블 설계 
-- 데이터베이스 생성

DROP DATABASE IF EXISTS `farmStory`;
CREATE DATABASE `farmStory`;
USE `farmStory`;

-- 사용자 생성 및 권한부여
DROP USER IF EXISTS 'farmStory'@'%';
CREATE USER 'farmStory'@'%' IDENTIFIED BY '1q2w3e';
GRANT ALL PRIVILEGES ON `farmStory`.* TO 'farmStory'@'%';
FLUSH PRIVILEGES;

-- User 테이블
CREATE TABLE `User` (
	`uid`			VARCHAR(20) PRIMARY KEY,
	`pass`		VARCHAR(100),
	`name`		VARCHAR(20),
	`nick`		VARCHAR(20) UNIQUE,
	`email`		VARCHAR(50) UNIQUE,
	`hp`			CHAR(13) UNIQUE,
	`role`		VARCHAR(20) DEFAULT 'USER',
	`zip`			CHAR(5),
	`addr1`		VARCHAR(100),
	`addr2`		VARCHAR(100),
	`regip`		VARCHAR(100),
	`regDate`	DATETIME,
	`leaveDate`	DATETIME
);

-- terms 테이블
CREATE TABLE `Terms` (
	`no`	INT PRIMARY KEY AUTO_INCREMENT,
	`terms`		TEXT,
	`privacy`	TEXT
);

-- article 테이블
CREATE TABLE `Article` (
	`no`			INT AUTO_INCREMENT PRIMARY KEY,
	`cate`		VARCHAR(20) DEFAULT 'free',
	`title`		VARCHAR(100) NOT NULL,
	`content`	TEXT NOT NULL,
	`comment`	INT DEFAULT 0,
	`file`		TINYINT DEFAULT 0,
	`hit`			INT DEFAULT 0,
	`writer`		VARCHAR(20) NOT NULL,
	`regip`		VARCHAR(100) NOT NULL,
	`wdate`		DATETIME,
	FOREIGN KEY (`writer`) REFERENCES `User` (`uid`)
);

-- comment 테이블
CREATE TABLE `Comment` (
	`cno`			INT AUTO_INCREMENT PRIMARY KEY,
	`parent`		INT NOT NULL,
	`content`	TEXT NOT NULL,
	`writer`		VARCHAR(20) NOT NULL,
	`regip`		VARCHAR(100) NOT NULL,
	`wdate`		DATETIME,
	FOREIGN KEY (`writer`) REFERENCES `User` (`uid`),
	FOREIGN KEY (`parent`) REFERENCES `Article` (`no`)
);

-- file 테이블
CREATE TABLE `File` (
	`fno`			INT AUTO_INCREMENT PRIMARY KEY,
	`ano`			INT NOT NULL,
	`oName`		VARCHAR(100) NOT NULL,
	`sName`		VARCHAR(100) NOT NULL,
	`download`	INT DEFAULT 0,
	`rdate`		DATETIME,
	FOREIGN KEY (`ano`) REFERENCES `Article` (`no`)
);


# 게시판 임시 데이터 - uid = admin
INSERT INTO `Article` (`cate`, `title`, `content`, `comment`, `file`, `hit`, `writer`, `regip`, `wdate`)
VALUES 
('notice', '공지사항 안내', '새로운 업데이트 공지드립니다.', 2, 0, 150, 'admin', '192.168.0.1', NOW()),
('free', '오늘의 일상', '오늘은 유난히 기분이 좋은 날이네요!', 5, 0, 87, 'admin', '203.0.113.5', NOW()),
('free', '좋은 책 추천해주세요', '자기계발 관련 좋은 책 추천받습니다.', 3, 0, 120, 'admin', '198.51.100.23', NOW()),
('qna', '자바 질문 있습니다.', '자바에서 인터페이스와 추상 클래스의 차이점이 뭔가요?', 1, 0, 45, 'admin', '172.16.254.3', NOW()),
('qna', 'MySQL 쿼리 최적화', '대량 데이터를 처리할 때 성능을 올릴 방법이 있을까요?', 7, 0, 250, 'admin', '203.0.113.42', NOW()),
('free', '유럽 여행지 추천', '다음 달에 유럽 여행을 가려고 하는데 어디가 좋을까요?', 10, 0, 300, 'admin', '198.51.100.7', NOW());

INSERT INTO `Article` (`cate`, `title`, `content`, `comment`, `file`, `hit`, `writer`, `regip`, `wdate`)
VALUES 
('notice', '서비스 점검 예정', '내일 새벽 2시부터 4시까지 서버 점검이 진행됩니다.', 3, 0, 180, 'admin', '192.168.0.2', NOW()),
('free', '오늘 점심 뭐 드셨나요?', '점심 메뉴 고민 중인데 추천 좀 해주세요!', 4, 0, 95, 'admin', '203.0.113.10', NOW()),
('free', '좋은 음악 추천해주세요', '요즘 들을만한 편안한 음악 추천 부탁드립니다.', 2, 0, 60, 'admin', '198.51.100.30', NOW()),
('qna', 'Spring Boot 질문', 'Spring Boot에서 @Transactional의 역할이 궁금합니다.', 6, 0, 140, 'admin', '172.16.254.10', NOW()),
('qna', 'CSS flexbox 질문', 'flex-grow와 flex-shrink의 차이점이 뭔가요?', 1, 0, 50, 'admin', '203.0.113.15', NOW()),
('free', '요즘 재미있는 드라마 추천', '최근 본 드라마 중 추천할 만한 게 있을까요?', 5, 0, 110, 'admin', '198.51.100.40', NOW()),
('free', '여행 가고 싶은 곳', '여행 가고 싶은 곳 리스트를 작성 중입니다.', 3, 0, 75, 'admin', '203.0.113.25', NOW()),
('notice', '신규 기능 업데이트', '이번 업데이트에서 추가된 주요 기능을 안내드립니다.', 2, 0, 200, 'admin', '192.168.0.3', NOW()),
('qna', 'Python vs Java', '데이터 분석에는 Python이 더 좋을까요, Java가 더 좋을까요?', 8, 0, 220, 'admin', '172.16.254.20', NOW()),
('free', '건강 관리 방법', '운동, 식습관 관리 등 건강을 위한 팁 공유해요.', 4, 0, 130, 'admin', '203.0.113.50', NOW());

