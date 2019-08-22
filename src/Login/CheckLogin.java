package Login;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckLogin extends HttpServlet {

	public void doGet(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html;charset=utf-8");
		String username = res.getParameter("username");
		String password = res.getParameter("password");
		if(username.equals("abc") && password.equals("123456")) {
			System.out.println("登录成功。。。。");
			resp.sendRedirect("welcome？username="+username);
		}else {
			System.out.println("登录失败。。。。");
			resp.sendRedirect("login");
		}
	}
	
	public void doPost(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException{
		this.doGet(res,resp);
	}
}
