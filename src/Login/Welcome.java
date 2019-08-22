package Login;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class Welcome extends HttpServlet {
	
	public void doGet(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>登录成功</h1>");
//		pw.println("Welcome!");
		pw.println("Welcome："+res.getParameter("username"));
		
	}
	
	public void doPost(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException{
		this.doGet(res,resp);
	}
}
