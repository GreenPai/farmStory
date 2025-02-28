package kr.co.pamStory.util;

public class SQL {

	// terms
	public static final String SELECT_TERMS = "select * from `terms` where `no`=?";
	
	// user
	public static final String SELECT_COUNT_USER = "select COUNT(*) from `user` ";
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

	
	
	
	
	
}