package lk.fadesign.fmrestinn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/fmrestinn?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String LOGIN_SQL = "SELECT * FROM users WHERE username = ? AND password = ?;";
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
     
    public boolean validateLogin(String uname, String pword) throws SQLException {
        ResultSet rs = null;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(LOGIN_SQL);) {
        	System.out.println(uname + " " +  pword);
            statement.setString(1, uname);
            statement.setString(2, pword);
            rs = statement.executeQuery() ;
            System.out.println(rs);
            if(rs.next()) {
            	System.out.println("true");
            	return true;
            	
            	
            }
            else {
            	System.out.println("false");
            	return false;
            }
            
        }
        
    }
    
}
