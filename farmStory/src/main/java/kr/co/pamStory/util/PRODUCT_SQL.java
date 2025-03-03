package kr.co.pamStory.util;

public class PRODUCT_SQL {

	// product 
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

}
