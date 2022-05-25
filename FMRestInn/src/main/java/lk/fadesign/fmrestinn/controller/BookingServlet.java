package lk.fadesign.fmrestinn.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.fadesign.fmrestinn.dao.BookingDao;
import lk.fadesign.fmrestinn.model.Booking;
import lk.fadesign.fmrestinn.model.Room;
import lk.fadesign.fmrestinn.model.User;

@WebServlet("/bookRoom")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDao bookingDao;

    public BookingServlet() {
        bookingDao = new BookingDao();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int room_id = Integer.parseInt(request.getParameter("room_id"));
        String checkin = request.getParameter("checkindate");
        String checkout = request.getParameter("checkoutdate");
        int bed = Integer.parseInt(request.getParameter("bed"));
        String meal = request.getParameter("meal");
        int rooms = Integer.parseInt(request.getParameter("rooms"));
        int total_cost = Integer.parseInt(request.getParameter("totalcost"));
        
        Room room = new Room(room_id);
        User user = new User(name, address, email, phone);
        Booking newBook = new Booking(user, room, checkin, checkout, bed, meal, rooms, total_cost);
        try {
			bookingDao.insertBooking(newBook);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.sendRedirect("index.jsp");
	}

}
