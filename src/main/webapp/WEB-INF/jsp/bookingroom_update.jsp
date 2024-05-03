<%@page import="java.text.SimpleDateFormat"%>
<%@page import="room.model.po.BookingRoom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	BookingRoom guestBook = (BookingRoom)request.getAttribute("bookingroom");
%>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWeb/css/buttons.css">
		<meta charset="UTF-8">
		<title>Booking Room Update</title>
	</head>
	<body style="padding: 15px">
		<!-- 修改留言 -->
		<form class="pure-form" action="/JavaWeb/bookingroom/update" method="post">
			<fieldset>
				<legend>GuestBook Update</legend>
				訂房序號： <input type="text" id="bookingId" name="bookingId" value="<%=guestBook.getBookingId() %>" readonly /><p>
				房間ID： <input type="text" id="roomId" name="roomId" value="<%=guestBook.getRoomId() %>"/><p>
				使用者ID： <input type="text" id="userId" name="userId" value="<%=guestBook.getUserId() %>"/><p>
				Checkin時間： <input type="date" id="checkinDate" name="checkinDate" value="<%=new SimpleDateFormat("YYYY-MM-dd").format(guestBook.getCheckinDate()) %>"/><p>
				<button type="submit" class="pure-button pure-button-primary">修改訂房資訊</button>
			</fieldset>
		</form>
		
		
	</body>
</html>