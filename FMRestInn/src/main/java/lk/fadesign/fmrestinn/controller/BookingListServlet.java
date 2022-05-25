package lk.fadesign.fmrestinn.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.fadesign.fmrestinn.dao.BookingDao;
import lk.fadesign.fmrestinn.model.Booking;

@WebServlet("/admin/bookingList")
public class BookingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDao bookingDao;
	
    public BookingListServlet() {
    	bookingDao = new BookingDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   List< Booking > bookingList = bookingDao.selectAllBookings();
	        request.setAttribute("bookingList", bookingList);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("bookedRooms.jsp");
	        dispatcher.forward(request, response);
	}


}
