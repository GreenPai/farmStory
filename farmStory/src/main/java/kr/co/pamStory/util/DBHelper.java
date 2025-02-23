package kr.co.pamStory.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBHelper {
	
	protected Connection conn = null;
	protected Statement stmt = null;
	protected PreparedStatement psmt = null;
	protected ResultSet rs = null;
	
	protected Connection getConnection() throws NamingException, SQLException {
		Context initCtx = new InitialContext();
		Context ctx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) ctx.lookup("jdbc/farmStory");
		return ds.getConnection();
	}
	
	protected void closeAll() throws SQLException {
		
		if(rs != null) {
			rs.close();
		}
	
		if(stmt != null) {
			stmt.close();
		}
		
		if(psmt != null) {
			psmt.close();
		}
		
		if(conn != null) {
			conn.close();
		}
		
	}
	
	
	
}
