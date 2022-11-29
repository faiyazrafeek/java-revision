package lk.faaz.usercrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DAO - Data Access Object
public class UserDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/learn_java?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO user(name, email, country) VALUES(?, ?, ?);";
	
	private static final String SELECT_USER_BY_ID = "SELECT id, name, email, country FROM user WHERE id = ?;";
	private static final String SELECT_ALL_USERS = "SELECT * FROM user;";
	private static final String DELETE_USERS_SQL = "DELETE FROM user WHERE id = ?;";
	private static final String UPDATE_USERS_SQL = "UPDATE user SET name = ?, email = ?, country = ? WHERE id = ?;";
	
	protected Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//	create or insert user
	
	//	update user
	
	//	select user by id
	
	//	select users
	
	//	delete user

}
