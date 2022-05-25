package lk.fadesign.fmrestinn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet("/")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomDao roomDao;

    public void init() {
    	roomDao = new RoomDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		try {
            switch (action) {
                case "/admin/new":   
                	showNewForm(request ,response);
                    break;
                case "/admin/addRoom":
                	insertRoom(request, response);
                    break;
                case "/admin/delete":
                    deleteRoom(request, response);
                    break;
                case "/admin/edit":
                    showEditForm(request, response);
                    break;
                case "/admin/update":
                    updateRoom(request, response);
                    break;
                case "/admin/rooms":
                	roomList(request, response);
                    break;
                default:
                    roomList(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
	}
	
    private void roomList(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List< Room > roomList = roomDao.selectAllRooms();
        request.setAttribute("roomList", roomList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("rooms.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addRoom.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("room_id"));
        Room existingUser = roomDao.selectRoom(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addRoom.jsp");
        request.setAttribute("room", existingUser);
        dispatcher.forward(request, response);
    }
	
	private void insertRoom(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        String bed = request.getParameter("bed");
        String type = request.getParameter("type");
        int count = Integer.parseInt(request.getParameter("count"));
        String image = request.getParameter("image");
        
        Room newRoom = new Room(title, description, price, bed, type, count, image);
        roomDao.insertRoom(newRoom);
        response.sendRedirect("rooms");
    }
	
    private void updateRoom(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        String bed = request.getParameter("bed");
        String type = request.getParameter("type");
        int count = Integer.parseInt(request.getParameter("count"));
        String image = request.getParameter("image");
        
        Room book = new Room(id, title, description, price, bed, type, count, image);
        roomDao.updateRoom(book);
        response.sendRedirect("rooms");
    }
    
    private void deleteRoom(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("room_id"));
        roomDao.deleteRoom(id);
        response.sendRedirect("rooms");

    }
   

}
