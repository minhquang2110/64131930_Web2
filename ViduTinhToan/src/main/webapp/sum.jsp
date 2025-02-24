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
	
	String strA=request.getParameter("a");
	float valueA=Float.parseFloat(strA);
	String strB=request.getParameter("b");
	float valueB=Float.parseFloat(strB);
	String strPt=request.getParameter("pt");
	String infor="";
	String result="";
	if(strPt.equals("+")){
		infor="TONG CUA ";
		result=String.valueOf(valueA+valueB);
	}else if(strPt.equals("-")){
		infor="HIEU CUA ";
		result=String.valueOf(valueA-valueB);
	}else if(strPt.equals("*")){
		infor="TICH CUA ";
		result=String.valueOf(valueA*valueB);
	}else{
		if(valueB==0){
			String redirectURL = "sum.html";
			String an="Khong_the_chia_cho_0";
			Cookie annouce=new Cookie("annouce",an);
			annouce.setMaxAge(60 * 60 * 24); 
			response.addCookie(annouce);
		    response.sendRedirect(redirectURL);
		}else{
			infor="THUONG CUA ";
			result=String.valueOf(valueA/valueB);
		}
	}
	Cookie userCookie = new Cookie("annouce", "");
	response.addCookie(userCookie);
	out.print(infor);
	out.print(valueA);
	out.print(" va ");
	out.print(valueB);
	out.print(" la ");
	out.print(result);
	%>
	 <form action="sum.html" method="post">
        <button type="submit">Quay lại</button>
    </form>
</body>
</html>