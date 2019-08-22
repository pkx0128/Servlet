package Login;


import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException {
//		获取HttpSession对象
		HttpSession se = res.getSession();
//		判断是否登录
		if(se.getAttribute("username")!=null) {
//			已登录跳转到Welcome页面
			resp.sendRedirect("welcome");
		}
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<h1>登录</h1>");
		pw.println("<form action=checkLogin method=post>");
		pw.println("用户名：<input type=text name=username></br>");
		pw.println("密码：<input type=password name=password></br>");
		pw.println("<input type=submit value=Login>");
		pw.println("</form>");
		pw.println("</html>");
	}
	
	public void doPost(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException {
		this.doGet(res, resp);
	}
	
}
