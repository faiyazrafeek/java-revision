package lk.fadesign.fmrestinn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lk.fadesign.fmrestinn.model.Room;

public class RoomDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/fmrestinn?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_ROOM_SQL = "INSERT INTO room (title, description, price, bed, type, count, image) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ROOM_BY_ID = "select id, title, description, price, bed, type, count, image from room where id =?";
    private static final String SELECT_ALL_ROOMS = "select * from room";
    private static final String DELETE_ROOM_SQL = "delete from room where id = ?;";
    private static final String UPDATE_ROOM_SQL = "update room set title = ?, description = ?, price = ?, bed = ?, type = ?, count = ?, image = ?  where id = ?;";
    
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
    
    public void insertRoom(Room room) throws SQLException {
        System.out.println(INSERT_ROOM_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_SQL)) {
            preparedStatement.setString(1, room.getTitle());
            preparedStatement.setString(2, room.getDescription());
            preparedStatement.setInt(3, room.getPrice());
            preparedStatement.setString(4, room.getBed());
            preparedStatement.setString(5, room.getType());
            preparedStatement.setInt(6, room.getCount());
            preparedStatement.setString(7, room.getImage());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public Room selectRoom(int id) {
    	Room room = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROOM_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                String bed = rs.getString("bed");
                String type = rs.getString("type");
                int count = rs.getInt("count");
                String image = rs.getString("image");
                room = new Room(id, title, description, price, bed, type, count, image);
                System.out.println("woring-----");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return room;
    }
    
    public List < Room > selectAllRooms() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Room > rooms = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                String bed = rs.getString("bed");
                String type = rs.getString("type");
                int count = rs.getInt("count");
                String image = rs.getString("image");
                rooms.add(new Room(id, title, description, price, bed, type, count, image));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rooms;
       
    }
    
    public boolean deleteRoom(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ROOM_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public boolean updateRoom(Room room) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM_SQL);) {
        	statement.setString(1, room.getTitle());
        	statement.setString(2, room.getDescription());
        	statement.setInt(3, room.getPrice());
        	statement.setString(4, room.getBed());
        	statement.setString(5, room.getType());
        	statement.setInt(6, room.getCount());
        	statement.setString(7, room.getImage());
            statement.setInt(8, room.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
