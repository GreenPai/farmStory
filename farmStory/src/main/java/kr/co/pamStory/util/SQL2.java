package kr.co.pamStory.util;

public class SQL2 {

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
	public static final String SELECT_MAX_NO = "SELECT MAX(`prodNo`) FROM `product`";
	
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

	public static final String SELECT_COUNT_USER = "SELECT COUNT(*) FROM `USER`";

	public static final String SELECT_ALL_USER_LIMIT_6 = "SELECT * FROM `USER` order BY `REGDATE` DESC LIMIT ?,6";

	public static final String SELECT_BEST_PRODUCT_6 = "";

	public static final String SELECT_USER = "SELECT * FROM `USER` WHERE `uid` = ?";

	public static final String SELECT_COUNT_USER_BY_UID = "SELECT COUNT(*) FROM article WHERE `writer` = ?";;
;
					
	
	
}