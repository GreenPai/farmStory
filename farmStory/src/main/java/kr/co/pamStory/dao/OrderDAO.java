package kr.co.pamStory.dao;



import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.OrderDTO;
import kr.co.pamStory.dto.ProductDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

public class OrderDAO  extends DBHelper {
	private static final OrderDAO INSTANCE = new OrderDAO();
	public static OrderDAO getInstance() {
		return INSTANCE;
	}
	private OrderDAO() {}
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	
	public List<OrderDTO> selectLatest3Orders(){
		
		List<OrderDTO> orders = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_ORDER_LIMIT_3);
			
			while(rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setOrderNo(rs.getInt(1));
				dto.setSname(rs.getString(2));
				dto.setProdName(rs.getString(3));
				dto.setItemPrice(rs.getInt(4));
				dto.setItemCount(rs.getInt(5));
				dto.setOrderTotalPrice(rs.getInt(4) * rs.getInt(5));
				dto.setOrderDate(rs.getString(7).substring(0,10));
				dto.setProdDeliveryFee(rs.getInt(8));
				dto.setOrderSender(rs.getString(9));
				dto.setProdNo(rs.getInt(10));
				orders.add(dto);
			}
			closeAll();
		}catch(Exception e) {
		
		}
		return orders;
	}
	
	
	public int insertOrder(OrderDTO dto) {
		
		int generatedKey= 0;
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL.INSERT_ORDER ,Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, dto.getUid());
			psmt.setInt(2, dto.getOrderTotalPrice());
			psmt.setString(3, dto.getOrderAddr());
			psmt.setInt(4, dto.getOrderStatus());
			psmt.setString(5, dto.getOrderSender());
			psmt.setString(6, dto.getOrderHp());
			psmt.setString(7, dto.getOrderReceiver());
			psmt.setString(8, dto.getReceiverHp());
			psmt.setString(9, dto.getOrderContent());
			psmt.setString(10, dto.getPayment());
			
			psmt.executeUpdate();
			
			//자동생성된 댓글번호 조회
			rs=psmt.getGeneratedKeys();
			if(rs.next()) {
				generatedKey=rs.getInt(1);
			}
			closeAll();
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return generatedKey;
		
	}
	
	public int selectCountOrder() {
		int total = 0;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_COUNT_ORDER);
			if (rs.next()) {
				total = rs.getInt(1);
			}
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	
	public int selectCountOrder(String uid) {
		int total = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_ORDER_BY_UID);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
			closeAll();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}

	public List<OrderDTO> selectAllOrder(int start, String uid) {
		
		List<OrderDTO> dtos = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDER_LIMIT_6);
			psmt.setString(1, uid);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setOrderNo(rs.getInt(1));
				dto.setSname(rs.getString(2));
				dto.setProdName(rs.getString(3));
				dto.setItemPrice(rs.getInt(4));
				dto.setItemCount(rs.getInt(5));
				dto.setOrderTotalPrice(rs.getInt(4) * rs.getInt(5));
				dto.setOrderDate(rs.getString(7).substring(0,10));
				dto.setProdDeliveryFee(rs.getInt(8));
				dto.setOrderSender(rs.getString(9));
				dto.setProdNo(rs.getInt(10));
				dtos.add(dto);
			}

			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return dtos;
	}
	
	public List<OrderDTO> selectAllOrder(int start) {
		List<OrderDTO> dtos = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDER_LIMIT_6_ADMIN);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setOrderNo(rs.getInt(1));
				dto.setSname(rs.getString(2));
				dto.setProdName(rs.getString(3));
				dto.setItemPrice(rs.getInt(4));
				dto.setItemCount(rs.getInt(5));
				dto.setOrderTotalPrice(rs.getInt(4) * rs.getInt(5));
				dto.setOrderDate(rs.getString(7).substring(0,10));
				dto.setProdDeliveryFee(rs.getInt(8));
				dto.setOrderSender(rs.getString(9));
				dto.setProdNo(rs.getInt(10));
				dtos.add(dto);
			}

			closeAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return dtos;
		
	}

	
	

}
