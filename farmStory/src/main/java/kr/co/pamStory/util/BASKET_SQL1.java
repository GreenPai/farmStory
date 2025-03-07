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
	
	

}
