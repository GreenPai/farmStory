package kr.co.pamStory.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.CartDTO;
import kr.co.pamStory.util.BASKET_SQL;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

public class CartDAO extends DBHelper {
	private static final CartDAO INSTANCE = new CartDAO();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static CartDAO getInstance() {
		return INSTANCE;
	}

	private CartDAO() {
	}

	public void insertCart(CartDTO dto) {
			
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(BASKET_SQL.INSERT_CART);
			psmt.setString(1, dto.getUid());
			psmt.setInt(2, dto.getProdNo());
			psmt.setInt(3, dto.getCartProdCount());
			psmt.executeUpdate();

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	public List<CartDTO> SelectCartByUid(String uid) {
		
		List<CartDTO> dtos = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(BASKET_SQL.SELECT_CART_BY_UID);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setSname(rs.getString(1));
				dto.setCateName(rs.getString(2));
				dto.setProdName(rs.getString(3));
				dto.setCartProdCount(rs.getInt(4));
				dto.setProdDiscount(rs.getInt(5));
				dto.setProdPoint(rs.getInt(6));
				dto.setProdPrice(rs.getInt(7));
				dto.setProdDeliveryFee(rs.getInt(8));
				dto.setCartNo(rs.getInt(9));
				dto.setProdDiscountPrice( (dto.getProdPrice() * (100-dto.getProdDiscount())) / 100);
				dto.setTotal(dto.getProdPrice() * dto.getCartProdCount());
				dtos.add(dto);
			}
			
			closeAll();	
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return dtos;
	}

	public void deleteCart(String cartNo) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(BASKET_SQL.DELETE_CART_BY_CARTNO);
			psmt.setString(1, cartNo);
			psmt.executeUpdate();
			
			closeAll();	
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
}
