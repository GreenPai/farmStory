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
	public static final String SELECT_COUNT_ARTICLE_BY_CATE = "SELECT COUNT(*) FROM `article` where `cate` = ?";;
	
	public final static String SELECT_ALL_ARTICLE_BY_SEARCH="SELECT " 
																		+ "a.*, "
																		+ "u.`nick` "
																		+ "FROM `article` AS a "
																		+ "JOIN `user` AS u ON a.writer=u.uid ";
	
	
	public static final String SELECT_ALL_ARTICLE="SELECT "
													+"a.*, "
													+"u.`nick` "
													+"FROM `article` AS a "
													+"JOIN `user` AS u "
													+"ON a.writer=u.uid "
													+"ORDER BY `no` desc "
													+"LIMIT ?, 10";
	
	public static final String SELECT_ALL_ARTICLE_BY_CATE_LIMIT_5 = "SELECT "
																	+"a.*, "
																	+"u.`nick` "
																	+"FROM `article` AS a "
																	+"JOIN `user` AS u "
																	+"ON a.writer=u.uid "
																	+ "where `cate` = ? "
																	+"ORDER BY `no` desc "
																	+"LIMIT 5";
	
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
	
	
	public final static String SELECT_COUNT_ARTICLE_FOR_SEARCH = "select count( * ) from `article` as a " ;
	public final static String JOIN_FOR_SEARCH_NICK  = "JOIN `user` as u ON a.writer = u.uid " ;
	public final static String WHERE_FOR_SEARCH_TITLE   = "WHERE `title` LIKE ? " ;
	public final static String WHERE_FOR_SEARCH_CONTENT = "WHERE `content` LIKE ? " ;
	public final static String WHERE_FOR_SEARCH_WRITER  = "WHERE `nick` LIKE ? " ;	
	public final static String ORDER_FOR_SEARCH  = "AND `cate` = ? ORDER BY `no` DESC " ;
	public final static String LIMIT_FOR_SEARCH  = "LIMIT ? , 10 " ;
													
			
	public static final String INSERT_ARTICLE = "insert into `article` set "
													+ "`title`=?,"
													+ "`content`=?,"
													+ "`file`=?,"
													+ "`writer`=?,"
													+ "`regip`=?,"
													+ "`cate`=?,"
													+ "`wdate`=NOW()";
	
	// file
	public static final String INSERT_FILE = "insert into `file` set "
												+ "`ano`=?,"
												+ "`oName`=?,"
												+ "`sName`=?,"
												+ "`rdate`=NOW()";

	public static final String DELETE_FILE_BY_ANO = "delete from `file` where `ano`=?";

	public static final String SELECT_FILE_BY_ANO = "select * from `file` where `ano`= ?";

	public static final String CHOOSE_FILE_BY_FNO = "select * from `file` where `fno`=?";
	
	public static final String SELECT_FILE_BY_SNAME = "select `sName` FROM `FILE` where `ano`=?";
	
	public static final String UPDATE_FILE_DOWNLOAD_COUNT = "update `file` set `download` = `download` + 1 where `fno`=?";

	public static final String SELECT_FILE_DOWNLOAD_COUNT = "select download from `file` where `fno`=?";
	
	public static final String UPDATE_FILE = "UPDATE `file`  set "
													+ "`oName`=?, "
													+ "`sName`=? "
													+ "WHERE `fno`=?";
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
														+"`content`=?, "
														+"`writer`=?, "
														+"`regip`=? "
														+"WHERE `cno` =?" ;

	// Info
	public static final String IS_CURRENT_PASSWORD_CORRECT = "SELECT pass FROM `user` WHERE `uid` = ?";

  public static final String SELECT_ALL_ARTICLE_BY_CATE = "SELECT "
																+"a.*, "
																+"u.`nick` "
																+"FROM `article` AS a "
																+"JOIN `user` AS u "
																+"ON a.writer=u.uid "
																+"WHERE `cate` = ? "
																+"ORDER BY `no` desc "
																+"LIMIT ?, 10";

	public static final String UPDATE_BY_CNO_BY_CNO_AND_CONTENT = "UPDATE `comment` SET"
														+"`content`=? "
														+"WHERE `cno` =?" ;

	
	/*
	 * -----------------------------------------------------
	 * product
	 * */
	
	// 상품 전체
	public static final String SELECT_ALL_PRODUCT = "SELECT p.*, i.sName, c.cateName "
													+ "FROM `product` as p "
													+ "join `image` as i on p.prodNo = i.prodNo "
													+ "join `category` as c on p.cateNo=c.cateNo "
													+ "order by `prodNo` desc";
	// 카테고리 별 상품 
	public static final String SELECT_ALL_PRODUCT_BY_CATENO = "SELECT p.*, i.sName, c.cateName "
																+ "FROM `product` as p "
																+ "join `image` as i on p.prodNo = i.prodNo "
																+ "join `category` as c on p.cateNo=c.cateNo "
																+ "WHERE c.`cateno` = ? "
																+ "order by `prodNo` desc ";
	// 상품번호에 맞는 상품 탐색
	public static final String SELECT_PRODUCT_BY_PRODNO =	"SELECT * FROM `product` WHERE `prodno` = ? ";
	
	// 상품번호에 맞는 재고량 변화
	public static final String MODIFY_PRODUCT_STOCK = "UPDATE `product`"
														+ " SET `prodstock` =  `prodstock` - ?, "
														+ "`prodSold` = `prodSold` + ? "
														+ "WHERE `prodNo` = ? ";

	// 상품 번호에 맞는 이미지 이름 탐색
	public static final String SELECT_SNAME_BY_PRODNO = "SELECT `sname` FROM `image` where `prodno` = ? ";
	
	/*
	 * ------------------------------------------------------
	 * Cart
	 * */
	// 장바구니 추가 
	public static final String INSERT_CART = "INSERT INTO `Cart`(`uid`,`prodNo`,`cartProdCount`,`cartProdDate`) values (?,?,?,NOW()) " ;
	
	public static final String SELECT_CART_BY_UID = "SELECT i.sName, g.cateName, p.prodName, c.cartProdCount, p.prodDiscount, p.prodPoint, p.prodPrice ,p.prodDeliveryFee, c.cartNo, p.prodNo FROM `cart` AS c JOIN `product` AS p ON c.prodNo = p.prodNo "
			+ "JOIN `category` AS g ON p.cateNo = g.cateNo "
			+ "JOIN `image` AS i ON i.prodNo = p.prodNo "
			+ "WHERE c.uid = ? " ;

	// 장바구니 삭제
	public static final String DELETE_CART_BY_CARTNO = "DELETE FROM `cart` where `cartNo` = ? ";
	public static final String DELETE_CART_BY_UID = "DELETE FROM `cart` where `uid` = ? ";
	
	
	/*
	 * --------------------------------------------------
	 * Order
	 * 주문
	 * */
	
	
	public static final String SELECT_POINT_BY_UID = "SELECT `userPoint` from `user` where `uid` = ? ";
	
	public static final String INSERT_ORDER = 
		    "INSERT INTO `order` (`uid`, `orderTotalPrice`, `orderAddr`, `orderStatus`,"
			+"`orderSender`, `senderHp`, `orderReceiver`, `receiverHp`, `orderContent`, `payment`, `orderDate`) " 
		    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
	
	
	public static final String INSERT_ORDERITEM = "INSERT INTO `orderitem` (`orderno`, `prodNo`, `itemPrice`, `itemDiscount`, `itemCount`) values(?,?,?,?,?)";
	
	// 주문 총량 계산(페이지용)
	public static final String SELECT_COUNT_ORDER = "SELECT COUNT(*) FROM `ORDER`";;
	public static final String SELECT_COUNT_ORDER_BY_UID = "SELECT COUNT(*) FROM `ORDER` WHERE `uid` = ?";

	public static final String SELECT_ORDER_LIMIT_6 = "SELECT o.orderNo, i.sName, p.prodName, oi.itemPrice, oi.itemCount, o.orderTotalPrice, o.orderDate, p.prodDeliveryFee, o.orderSender, p.prodNo "
													+ "FROM `order` AS o JOIN `orderitem` AS oi ON o.orderNo = oi.orderNo "
													+ "JOIN `product` AS p ON oi.prodNo = p.prodNo "
													+ "JOIN `image` AS i ON i.prodNo = p.prodNo "
													+ "WHERE o.uid = ? "
													+ "order by `orderNo` desc "
													+ "  LIMIT ?, 6";

	public static final String SELECT_ORDER_LIMIT_6_ADMIN = "SELECT o.orderNo, i.sName, p.prodName, oi.itemPrice, oi.itemCount, o.orderTotalPrice, o.orderDate, p.prodDeliveryFee, o.orderSender, p.prodNo "
																+ "FROM `order` AS o JOIN `orderitem` AS oi ON o.orderNo = oi.orderNo "
																+ "JOIN `product` AS p ON oi.prodNo = p.prodNo "
																+ "JOIN `image` AS i ON i.prodNo = p.prodNo "
																+ "order by `orderNo` desc "
																+ "  LIMIT ?, 6";

	/*
	 * --------------------------------------------------
	 * Point
	 * 포인트
	 * */
	
	// 포인트 적립
	public static final String INSERT_POINT = "INSERT INTO `point`(`uid`,`point`,`pointDesc`,`pointDate`) values(?,?,?,NOW())";
	
	// 유저 포인트 총량 
	public static final String MODIFY_POINT = "UPDATE `user` SET `userPoint` =  `userPoint` + ? WHERE `uid` = ? ";

	

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */


	// category
	public static final String SELECT_CATEGORY_BY_CATENAME = "SELECT * FROM `category` where `cateName` = ?";
	
	// product
	public static final String INSERT_PRODUCT = "insert into `product` set "
												+ "`cateNo` = ?,"
												+ "`prodName` = ?," 
												+ "`prodPrice` = ?,"
												+ "`prodStock` = ?,"
												+ "`prodDiscount` = ?,"
												+ "`prodPoint` = ?,"											
												+ "`prodDeliveryFee` = ?,"
												+ "`prodcontent` = ?,"
												+ "regDate=now()";
	
	// SELECT_MAX_NO
	public static final String SELECT_MAX_NO_PRODUCT = "SELECT MAX(`prodNo`) FROM `product`";
	
	// image
	public static final String INSERT_IMAGE = "insert into `image` set "
												+ "`prodNo` = ?,"
												+ "`oName` = ?,"
												+ "`sName` = ?,"
												+ "`rdate` = now()";

	// 상품 최신 데이터 3개 출력
	public static final String SELECT_PRODUCT_LIMIT_3 = "SELECT * FROM `PRODUCT` as p "
			+ "join category as c on p.cateNo = c.cateNo  "
			+ "order BY `PRODNO` DESC LIMIT 0,3";
												
	// 회원 최신 데이터 3개 출력
	public static final String SELECT_USER_LIMIT_3 = "SELECT * FROM `USER` order BY `REGDATE` DESC LIMIT 0,3";
		
	// 주문 최신 데이터 3개 출력
	public static final String SELECT_ORDER_LIMIT_3 = "SELECT o.orderNo, i.sName, p.prodName, oi.itemPrice, oi.itemCount, o.orderTotalPrice, o.orderDate, p.prodDeliveryFee, o.orderSender, p.prodNo "
													+ "FROM `order` AS o JOIN `orderitem` AS oi ON o.orderNo = oi.orderNo "
													+ "JOIN `product` AS p ON oi.prodNo = p.prodNo "
													+ "JOIN `image` AS i ON i.prodNo = p.prodNo "
													+ "order BY `ORDERDATE` DESC"
													+ " LIMIT 0, 3";

	// 상품 전체 데이터 출력
	public static final String SELECT_PRODUCT_ALL = "SELECT p.*, c.cateName, i.sName FROM `PRODUCT` as p "
	                                                + "JOIN `category` as c ON p.cateNo = c.cateNo "
	                                                + "JOIN `image` as i ON p.prodNo = i.prodNo "
	                                                + "ORDER BY p.regDate DESC";

	public static final String SELECT_ALL_USER = "SELECT * FROM `USER`";

	public static final String DELETE_PRODUCT = "DELETE FROM `PRODUCT` WHERE `PRODNO` = ? ";

	public static final String DELETE_IMAGE = "DELETE FROM `IMAGE` WHERE `PRODNO` = ? ";

	public static final String SELECT_COUNT_PRODUCT = "SELECT COUNT(*) FROM `PRODUCT`";

	// 상품 데이터 6개 출력(페이징)
	public static final String SELECT_PRODUCT_LIMIT_6 =  "SELECT p.*, c.cateName, i.sName FROM `PRODUCT` as p "
											            + "JOIN `category` as c ON p.cateNo = c.cateNo "
											            + "JOIN `image` as i ON p.prodNo = i.prodNo "
											            + "ORDER BY p.regDate DESC "
											            + "LIMIT ?, 6";

	//SELECT_COUNT_USER

	public static final String SELECT_ALL_USER_LIMIT_6 = "SELECT * FROM `USER` order BY `REGDATE` DESC LIMIT ?,6";

	public static final String SELECT_BEST_PRODUCT_6 = "SELECT p.*, c.cateName, i.sName FROM `PRODUCT` as p "
											            + "JOIN `category` as c ON p.cateNo = c.cateNo "
											            + "JOIN `image` as i ON p.prodNo = i.prodNo "
											            + "ORDER BY p.regDate DESC "
											            + "LIMIT 6";

	// SELECT_USER
	public static final String SELECT_USER_BY_UID = "SELECT * FROM `USER` WHERE `uid` = ?";

	public static final String SELECT_COUNT_USER_BY_UID = "SELECT COUNT(*) FROM article WHERE `writer` = ?";


}