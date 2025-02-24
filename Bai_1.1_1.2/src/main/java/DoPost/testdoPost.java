package DoPost;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class testdoPost
 */
public class testdoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testdoPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter pt=response.getWriter();
		pt.append("Bạn vừa gửi yêu cầu GET, đây là đáp ứng của tôi");
		String ndHtml="<form method=\"post\" action=\"testdoPost\""
				+"<label>Họ: </label>"
				+"<input type=\"text\" name=\"fname\"> <br>\r\n"
				+"<label>Tên: </label>"
				+"<input type=\"text\" name=\"lname\"> <br>"
				+"<input type=\"submit\" value=\"Gửi đi\">"
				+"</form>";
		pt.append(ndHtml);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String value1=request.getParameter("fname");
		String value2=request.getParameter("lname");
		PrintWriter pt=response.getWriter();
		pt.append("Bạn vừa gửi yêu cầu POST, đây là đáp ứng của tôi\n");
		String ndHtml="<br><label>Gía trị tham số fname = "
				+value1
				+"</label><br>"
				+"<label>Gía trị tham số lname = "
				+value2
				+"</label>";
		pt.append(ndHtml);
	
		
	}

}
