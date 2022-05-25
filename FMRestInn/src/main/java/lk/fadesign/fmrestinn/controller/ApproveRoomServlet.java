package lk.fadesign.fmrestinn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.fadesign.fmrestinn.dao.BookingDao;
import lk.fadesign.fmrestinn.dao.RoomDao;
import lk.fadesign.fmrestinn.model.Booking;
import lk.fadesign.fmrestinn.model.Room;


@WebServlet("/admin/approveRoom")
public class ApproveRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDao bookingDao;
    /**
     * Default constructor. 
     */
    public ApproveRoomServlet() {
    	bookingDao = new BookingDao();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("book_id"));
		Booking booking= bookingDao.selectBooking(id);
		String name = booking.getUser().getName();
		int room_id = booking.getRoom().getId();
		String hotel = "FM Rest Inn";
		String checkin = booking.getCheckin();
		String checkout = booking.getCheckout();
		int rooms = booking.getRooms();
		
		String email = booking.getUser().getEmail();
		
		if(email!=null || !email.equals("")) {
			// sending otp
			
			String to = email;// change accordingly
			// Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("fadesign001@gmail.com", "fodmzayjtsqndcev");// Put your email
																									// id and
																									// password here
				}
			});
			// compose message
			try {
				bookingDao.updateBookingStatus(booking);
				MimeMessage message = new MimeMessage(session);
				String body = "<p>Thanks, " + name + "!</p> <p style='color:blue; fontWeight : bold'>Your Booking for <bold> Room No." + room_id + "</bold> is Confirmed.</p> <ul> <li>Check-In: " + checkin + "</li><li>Checkout: " + checkout + "</li><li>Rooms: "+ rooms+ "</li></ul><br><br>" + hotel;
				message.setFrom(new InternetAddress(email));// change accordingly
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("FM Rest Inn | Room Booking");
				message.setContent(body, "text/html; charset=utf-8");
				//message.setText("Thanks, " + name + " !\n\nYour Booking for Room No." + room_id + " is Confirmed.\n\nCheck-In: " + checkin + "\nCheckout: " + checkout + "\nRooms: "+ rooms+ "\n\n\n" + hotel);
				// send message
				Transport.send(message);
				System.out.println("message sent successfully");
			}

			catch (MessagingException e) {
				throw new RuntimeException(e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("rooms");
		}
	}

}
