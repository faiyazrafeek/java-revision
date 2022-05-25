package lk.fadesign.fmrestinn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lk.fadesign.fmrestinn.model.Booking;
import lk.fadesign.fmrestinn.model.Room;
import lk.fadesign.fmrestinn.model.User;

public class BookingDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/fmrestinn?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
    private static final String INSERT_BOOKING_SQL = "INSERT INTO booking (name, address, email, phone, room_id, checkin, checkout, bed, meal, rooms, total_cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_BOOKING_BY_ID = "select id, name, address, email, phone, room_id, checkin, checkout, rooms, total_cost from booking where id = ?";
    private static final String SELECT_ALL_BOOKINGS = "select * from booking";
    private static final String UPDATE_ROOMS_SQL = "UPDATE room SET count = count - ? WHERE id = ?;";
    private static final String UPDATE_BOOKING_STATUS_SQL = "UPDATE booking SET status = '1' WHERE id = ?;";
    
    
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
    
    public void insertBooking(Booking booking) throws SQLException {
        System.out.println(INSERT_BOOKING_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING_SQL)) {
            preparedStatement.setString(1, booking.getUser().getName());
            preparedStatement.setString(2, booking.getUser().getAddress());
            preparedStatement.setString(3, booking.getUser().getEmail());
            preparedStatement.setString(4, booking.getUser().getPhone());
            preparedStatement.setInt(5, booking.getRoom().getId());
            preparedStatement.setString(6, booking.getCheckin());
            preparedStatement.setString(7, booking.getCheckout());
            preparedStatement.setInt(8, booking.getBed());
            preparedStatement.setString(9, booking.getMeal());
            preparedStatement.setInt(10, booking.getRooms());
            preparedStatement.setInt(11, booking.getTotalcost());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            updateRoom(booking.getRooms(), booking.getRoom());
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public Booking selectBooking(int id) {
    	Booking booking = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {                
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                
                int room_id = rs.getInt("room_id");
                
                String checkin = rs.getString("checkin");
                String checkout = rs.getString("checkout");
                
                int rooms = rs.getInt("rooms");
                int total_cost = rs.getInt("total_cost");
                
                User user = new User(name, address, email, phone);
                Room room = new Room(room_id);
                booking = new Booking(id, user, room, checkin, checkout, 0, "none", rooms, total_cost);
                System.out.println("woring-----");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return booking;
    }
    
    public List < Booking > selectAllBookings() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Booking > bookings = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKINGS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int room_id = rs.getInt("room_id");
                String checkin = rs.getString("checkin");
                String checkout = rs.getString("checkout");
                int bed = rs.getInt("bed");
                String meal = rs.getString("meal");
                int rooms = rs.getInt("rooms");
                int total_cost = rs.getInt("total_cost");
                String status = rs.getString("status");
                
                Room room = new Room(room_id);
                User user = new User(name, address, email, phone);
                bookings.add(new Booking(id, user, room, checkin, checkout, bed, meal, rooms, total_cost, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bookings;
       
    }
    
    public boolean updateRoom(int count, Room room) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ROOMS_SQL);) {
        	statement.setInt(1, count);
        	statement.setInt(2, room.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public boolean updateBookingStatus(Booking booking) throws SQLException {
    	boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKING_STATUS_SQL);) {
        	statement.setInt(1, booking.getId());
        	
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
