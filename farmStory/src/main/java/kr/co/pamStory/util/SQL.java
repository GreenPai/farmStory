package kr.co.pamStory.util;

public class SQL {

	// terms
	public static final String SELECT_TERMS = "select * from `terms` where `no`=?";
	
	// user
	public static final String SELECT_COUNT_USER = "select COUNT(*) from `user` ";
	public static final String SELECT_USER_BY_NAME_AND_EMAIL = "SELECT "
																+ "`name`,"
																+ "	`uid`,"
																+ "`email`,"
																+ "`regDate` "
																+ "FROM `user` WHERE `name`= ? AND `email` = ? ";
	
	public static final String SELECT_USER_BY_UID_AND_EMAIL = "SELECT "
																+ "`uid`,"
																+ "`pass` "
																+ "FROM `user` WHERE `uid`= ? AND `email` = ? ";
	public static final String UPDATE_PASSWORD = "UPDATE `user` "
													+ "SET `pass` = ? "
													+ "WHERE `uid` = ?";
	/*
	public static final String SELECT_RESULT_FIND_ID = "SELECT "
														+ "	`name`,"
														+ "	`uid`,"
														+ "	`email`,"
														+ "	`regDate` "
														+ "FROM `user` "
														+ "WHERE `name` = ? AND `uid` = ? AND `email` = ? AND `regDate` = ?";
	*/
	
	
	public static final String WHERE_UID = "where `uid`=?";
	public static final String WHERE_NICK = "where `nick`=?";
	public static final String WHERE_EMAIL = "where `email`=?";
	public static final String WHERE_HP = "where `hp`=?";
	
	public static final String SELECT_USER = "select * from `user` where `uid`=? and `pass`=SHA2(?, 256)";
	public static final String INSERT_USER = "insert into `user` set "
											+ "`uid`=?,"
											+ "`pass`=SHA2(?, 256),"
											+ "`name`=?,"
											+ "`nick`=?,"
											+ "`email`=?,"
											+ "`hp`=?,"
											+ "`zip`=?,"
											+ "`addr1`=?,"
											+ "`addr2`=?,"
											+ "`regip`=?,"
											+ "`regDate`=NOW()";
	
	// article
	public static final String SELECT_MAX_NO = "SELECT MAX(`no`) FROM `article`";
	public static final String SELECT_COUNT_ARTICLE= "SELECT COUNT(*) FROM `article`";
	
	public final static String SELECT_ALL_ARTICLE_BY_SEARCH="SELECT" 
																		+ "a.*, "
																		+ "u.`nick` "
																		+ "FROM `article` AS a "
																		+ "JOIN `user` AS u ON a.writer=u.uid ";
	
	
	public static final String SELECT_ALL_ARTICLE="SELECT "
													+"a.*,"
													+"u.`nick` "
													+"FROM `article` AS a "
													+"JOIN `user` AS u "
													+"ON a.writer=u.uid "
													+"ORDER BY `no` desc "
													+"LIMIT ?, 10";
	
	public static final String SELECT_ARTICLE_BY_NO = "SELECT "
																	+ " a.*, u.`nick` "
																	+ "FROM `article` As a "
																	+ "JOIN `User` AS u "
																	+"ON a.writer = u.uid "
																	+ "WHERE `no` = ? ";
	
	public static final String DELETE_ARTICLE="DELETE FROM `article` WHERE no=?";
	
	public static final String UPDATE_BY_NO = "UPDATE `article` SET"
															+"`title`=?, "
															+"`content`=?, "
															+"`writer`=?, "
															+"`regip`=? "
															+"WHERE `no` =?" ;
	
	
	public final static String SELECT_COUNT_ARTICLE_FOR_SEARCH = "select count(*) from `article` as a ";
	public final static String JOIN_FOR_SEARCH_NICK  = "JOIN `user` as u ON a.writer = u.uid ";
	public final static String WHERE_FOR_SEARCH_TITLE   = "WHERE `title` LIKE ? ";
	public final static String WHERE_FOR_SEARCH_CONTENT = "WHERE `content` LIKE ? ";
	public final static String WHERE_FOR_SEARCH_WRITER  = "WHERE `nick` LIKE ? ";	
	public final static String ORDER_FOR_SEARCH  = "ORDER BY `no` DESC ";
	public final static String LIMIT_FOR_SEARCH  = "LIMIT ?, 10";
													
			
	public static final String INSERT_ARTICLE = "insert into `article` set "
													+ "`title`=?,"
													+ "`content`=?,"
													+ "`file`=?,"
													+ "`writer`=?,"
													+ "`regip`=?,"
													+ "`wdate`=NOW()";
	
	// file
	public static final String INSERT_FILE = "insert into `file` set "
												+ "`ano`=?,"
												+ "`oName`=?,"
												+ "`sName`=?,"
												+ "`rdate`=NOW()";

	public static final String DELETE_FILE_BY_ANO = "delete from `file` where `ano`=?";

	public static final String SELECT_FILE_BY_ANO = "select * from `file` where `ano`= ?";

	//comment
	public static final String INSERT_COMMENT = "insert into `comment` set "
																+"`parent`=?, "
																+"`content`=?, "
																+"`writer`=?, "
																+"`regip`=?, "
																+"`wdate`=NOW()";


	public static final String SELECT_COMMENT_BY_CNO = "SELECT " 
																+ "c.*, "
																+ "u.`nick` "
																+ "FROM `comment` AS c "
																+ "JOIN `user` AS u ON c.writer=u.uid "
																+ "WHERE `cno`=?";

	public static final String SELECT_ALL_COMMENT_BY_PARENT = "SELECT "
																+ "c.*, "
																+ "u.`nick` "
																+ "FROM `comment` AS c "
																+ "JOIN `user` AS u ON c.writer=u.uid "
																+ "WHERE `parent`=? "
																+ "ORDER BY `cno` ASC";

	public static final String DELETE_COMMENT = "DELETE FROM `comment` WHERE cno=?";

	public static final String UPDATE_BY_CNO = "UPDATE `comment` SET"
														+"`cno`=?, "
														+"`content`=?, "
														+"`writer`=?, "
														+"`regip`=? "
														+"WHERE `cno` =?" ;

	

	



}