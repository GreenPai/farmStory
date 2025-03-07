package kr.co.pamStory.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.pamStory.dto.OrderItemDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL;

public class OrderItemDAO  extends DBHelper {
	private static final OrderItemDAO INSTANCE = new OrderItemDAO();
	public static OrderItemDAO getInstance() {
		return INSTANCE;
	}
	private OrderItemDAO() {}
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	public void insertOrderItem(OrderItemDTO dto) {

		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL.INSERT_ORDERITEM);
			psmt.setInt(1, dto.getOrderNo());
			psmt.setInt(2, dto.getProdNo());
			psmt.setInt(3, dto.getItemPrice());
			psmt.setInt(4, dto.getItemDiscount());
			psmt.setInt(5, dto.getItemCount());
			
			psmt.executeUpdate();
			
			closeAll();
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	

}
