package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TEST {
	public static void main(String[] args) {
		Connection conn = mariaDB();
		
		PreparedStatement pstmt = null;
		String sql = "SELECT 1 FROM DUAL";
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				System.out.println(rs.getInt(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection mariaDB(){
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://1.237.79.161:3307/haksa";
		String user = "root";
		String password = "Qwe123";
		
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
