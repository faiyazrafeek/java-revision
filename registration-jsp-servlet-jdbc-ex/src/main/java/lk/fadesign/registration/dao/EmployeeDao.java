package lk.fadesign.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lk.fadesign.registration.model.Employee;

public class EmployeeDao {
	public int regsiterEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employee" +
				" (first_name, last_name, username, password, address, contact) VALUES " +
				" (?, ?, ?, ?, ?, ?);";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/learn_java?useSSL=false", "root", "");
				
//				Step 2L Create a statement using connection obj
				PreparedStatement pst = conn.prepareStatement(INSERT_USERS_SQL)){
				pst.setString(1, employee.getFirstName());
				pst.setString(2, employee.getLastName());
				pst.setString(3, employee.getUsername());
				pst.setString(4, employee.getPassword());
				pst.setString(5, employee.getAddress());
				pst.setString(6, employee.getContact());
				
				System.out.println(pst);
				
//				Step 3: Execute the query or update query
				result = pst.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
