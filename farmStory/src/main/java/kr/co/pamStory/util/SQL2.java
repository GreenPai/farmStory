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
	public static final String SELECT_ORDER_LIMIT_3 = "SELECT * FROM `ORDER` order BY `ORDERDATE` DESC LIMIT 0,3";

	// 상품 전체 데이터 출력
	public static final String SELECT_PRODUCT_ALL = "SELECT p.*, c.cateName FROM `PRODUCT` as p "
													+ "join category as c on p.cateNo = c.cateNo "
													+ "order BY `regDate` DESC";

	public static final String SELECT_ALL_USER = "SELECT * FROM `USER`";
					
	
	
}