package lk.fadesign.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import lk.fadesign.registration.model.Employee;

public class EmployeeDao {
	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employees" + 
				"(first_name, last_name, username, password, address, contact) VALUES" +
				" (?,?,?,?,?,?)";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycompany?useSSL=false", "root", "");
				
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
					preparedStatement.setString(1, employee.getFirstname());
					preparedStatement.setString(2, employee.getLastname());
					preparedStatement.setString(3, employee.getUsername());
					preparedStatement.setString(4, employee.getPassword());
					preparedStatement.setString(5, employee.getAddress());
					preparedStatement.setString(6, employee.getContact());
					
					System.out.println(preparedStatement);
					
					result = preparedStatement.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}
		
		return result;
		
	}
}
