<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	if(username.equals("ABC")&&password.equals("MNK")){
		response.sendRedirect("UserProfile.html");
	}else{
		Cookie cook=new Cookie("annouce","Tên_đăng_nhập_hoặc_mật_khẩu_không_đúng");
		cook.setMaxAge(60 * 60 * 24); 
		response.addCookie(cook);
		response.sendRedirect("Login.html");
	}
	%>
</body>
</html>