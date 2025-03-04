package kr.co.pamStory.dao;



import java.util.ArrayList;
import java.util.List;



import kr.co.pamStory.dto.OrderDTO;
import kr.co.pamStory.util.DBHelper;
import kr.co.pamStory.util.SQL2;

public class OrderDAO  extends DBHelper {
	private static final OrderDAO INSTANCE = new OrderDAO();
	public static OrderDAO getInstance() {
		return INSTANCE;
	}
	private OrderDAO() {}
	
	public List<OrderDTO> selectLatest3Orders(){
		
		List<OrderDTO> dtos = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL2.SELECT_ORDER_LIMIT_3);
			
			while(rs.next()) {
				/*
				OrderDTO dto = new OrderDTO();
				dto.setOrderNo(rs.getInt(1));
				dto.setOrderName(rs.getString(2));
				dto.setOrderPrice(rs.getInt(3));
				dto.setItemCount(rs.getInt(4));
				dto.
				*/
			}
		}catch(Exception e) {
		
		}
		return dtos;
	}

	
	

}
