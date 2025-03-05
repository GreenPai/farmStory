package kr.co.pamStory.dao;



import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.OrderDTO;
import kr.co.pamStory.util.BASKET_SQL;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;
import kr.co.pamStory.util.SQL2;

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
			rs = stmt.executeQuery(SQL2.SELECT_ORDER_LIMIT_3);
			
			while(rs.next()) {
				/*
				OrderDTO order = new OrderDTO();
				dto.setOrderNo(rs.getInt(1));
				dto.setOrderName(rs.getString(2));
				dto.setOrderPrice(rs.getInt(3));
				dto.setItemCount(rs.getInt(4));
				dto.
				*/
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
			psmt=conn.prepareStatement(BASKET_SQL.INSERT_ORDER ,Statement.RETURN_GENERATED_KEYS);
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

	
	

}
