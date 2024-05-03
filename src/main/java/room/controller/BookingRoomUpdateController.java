package room.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import room.service.BookingRoomService;

// 進行 Room 修改
@WebServlet("/bookingroom/update")
public class BookingRoomUpdateController extends HttpServlet {
	private BookingRoomService bookingRoomService = new BookingRoomService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 取得 Room ID
		Integer bookingId = Integer.parseInt(req.getParameter("updateId"));
		
		// 取得 Room 資料
		req.setAttribute("bookingroom", bookingRoomService.getBookingRoom(bookingId));
		// 轉發至 Room 修改頁面
		req.getRequestDispatcher("/WEB-INF/jsp/bookingroom_update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 取得 Room ID
		Integer bookingId = Integer.parseInt(req.getParameter("bookingId"));
		Integer roomId = Integer.parseInt(req.getParameter("roomId"));
		Integer userId = Integer.parseInt(req.getParameter("userId"));
		String checkinDate = req.getParameter("checkinDate");
			
		bookingRoomService.updateBookingRoom(bookingId, roomId, userId, checkinDate);
		
		// 重新導向至 Room 主頁面
		resp.sendRedirect(req.getContextPath() + "/bookingroom");
		
		
//		// 取得 Room ID
//		Integer roomId = Integer.parseInt(req.getParameter("roomId"));
//		// 取得 Room 名稱
//		String roomName = req.getParameter("roomName");
//		// 取得 Room 資料
//		service.updateRoom(roomId, roomName);
//		// 重新導向至 Room 主頁面
//		resp.sendRedirect(req.getContextPath() + "/room");
	}
	
}