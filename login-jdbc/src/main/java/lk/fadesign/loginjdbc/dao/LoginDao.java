package lk.fadesign.loginjdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lk.fadesign.loginjdbc.model.Login;

public class LoginDao {
	public boolean validate(Login login) throws ClassNotFoundException {
		boolean status = false;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycompany?useSSL=false", "root", "");
				
				PreparedStatement pst = connection.prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?")){
			pst.setString(1, login.getUsername());
			pst.setString(2, login.getPasssword());
			
			System.out.println(pst);
			ResultSet rs = pst.executeQuery();
			status = rs.next();
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
	}
}
