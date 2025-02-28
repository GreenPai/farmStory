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
												+ "`prodcontent` = ?";
	public static final String SELECT_MAX_NO = "SELECT MAX(`prodNo`) FROM `product`";
	
	// image
	public static final String INSERT_IMAGE = "insert into `image` set "
												+ "`prodNo` = ?,"
												+ "`oName` = ?,"
												+ "`sName` = ?,"
												+ "`rdate` = now()";
												

					
	
	
}