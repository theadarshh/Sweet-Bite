package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tap.dao.FeedBackDao;
import com.tap.model.Order;
import com.tap.model.userFeedBack;

public class FeedBackDaoImpl implements FeedBackDao{

	
	 static private final String URL = "jdbc:mysql://localhost:3306/tapfoods";
	    static private final String USERNAME = "root";
	    static private final String PASSWORD = "root";
	    Connection conn = null;

	public FeedBackDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public boolean addFeedBack(userFeedBack feedback) {
	    String sql = "INSERT INTO `feedback` (`userId`, `feedback`) VALUES (?, ?)";
	    boolean success = false;

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, feedback.getUserId());
	        pstmt.setString(2, feedback.getFeedBack());

	        int rows = pstmt.executeUpdate();
	        success = (rows == 1);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return success;
	}
}