package kr.co.pamStory.util;

public class BASKET_SQL {

	/*
	 * -----------------------------------------------------
	 * product
	 * */
	
	// 상품 전체
	public static final String SELECT_ALL_PRODUCT = "SELECT p.*, i.sName, c.cateName "
													+ "FROM `product` as p "
													+ "join `image` as i on p.prodNo = i.prodNo "
													+ "join `category` as c on p.cateNo=c.cateNo";
	// 카테고리 별 상품 
	public static final String SELECT_ALL_PRODUCT_BY_CATENO = "SELECT p.*, i.sName, c.cateName "
																+ "FROM `product` as p "
																+ "join `image` as i on p.prodNo = i.prodNo "
																+ "join `category` as c on p.cateNo=c.cateNo "
																+ "WHERE c.`cateno` = ? ";
	// 상품번호에 맞는 상품 탐색
	public static final String SELECT_PRODUCT_BY_PRODNO =	"SELECT * FROM `product` WHERE `prodno` = ? ";
	
	// 상품 번호에 맞는 이미지 이름 탐색
	public static final String SELECT_SNAME_BY_PRODNO = "SELECT `sname` FROM `image` where `prodno` = ? ";
	
	/*
	 * ------------------------------------------------------
	 * Cart
	 * */
	// 장바구니 추가 
	public static final String INSERT_CART = "INSERT INTO `Cart`(`uid`,`prodNo`,`cartProdCount`,`cartProdDate`) values (?,?,?,NOW()) " ;
	
	public static final String SELECT_CART_BY_UID = "SELECT i.sName, g.cateName, p.prodName, c.cartProdCount, p.prodDiscount, p.prodPoint, p.prodPrice ,p.prodDeliveryFee, c.cartNo FROM `cart` AS c JOIN `product` AS p ON c.prodNo = p.prodNo "
			+ "JOIN `category` AS g ON p.cateNo = g.cateNo "
			+ "JOIN `image` AS i ON i.prodNo = p.prodNo "
			+ "WHERE c.uid = ? " ;
	public static final String DELETE_CART_BY_CARTNO = "DELETE FROM `cart` where `cartNo` = ? ";
	
	
	/*
	 * --------------------------------------------------
	 * Order
	 * 주문
	 * */
	public static final String SELECT_POINT_BY_UID = "SELECT `userPoint` from `user` where `uid` = ? ";

}
