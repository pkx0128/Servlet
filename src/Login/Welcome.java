package Login;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet {
	
	public void doGet(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException{
//		获取HttpSession对象
		HttpSession se = res.getSession();
//		判断是否登录
		if(se.getAttribute("username")==null) {
//			还未登录跳转到登录
			resp.sendRedirect("login");
		}
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>登录成功</h1>");
		System.out.println(se.getAttribute("username"));
//		pw.println("Welcome!");
//		pw.println("Welcome："+res.getParameter("username")+"密码："+res.getParameter("password"));
		pw.println("Welcome："+se.getAttribute("username")+"密码："+se.getAttribute("password"));
		pw.println("</br>");
		pw.println("<a href=loginout>安全退出</a>");
		
	}
	
	public void doPost(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException{
		this.doGet(res,resp);
	}
}
