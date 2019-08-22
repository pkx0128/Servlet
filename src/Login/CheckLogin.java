package Login;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckLogin extends HttpServlet {

	public void doGet(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException{
//		获取HttpSession对象
		HttpSession session = res.getSession();
		resp.setContentType("text/html;charset=utf-8");
		String username = res.getParameter("username");
		String password = res.getParameter("password");
//		判断指定用户名和密码
		if(username.equals("abc") && password.equals("123456")) {
//			保存登录用户名到Session
			session.setAttribute("username", username);
//			保存登录密码到Session
			session.setAttribute("password", password);
//			设置Session有效时间为30秒
			session.setMaxInactiveInterval(30);
			
			System.out.println("登录成功。。。。");
//			跳转到Welcome页面并且传递username的值
//			resp.sendRedirect("welcome？username="+username+"&password="+password);
//			跳转到Welcome页面
			resp.sendRedirect("welcome");
		}else {
			System.out.println("登录失败。。。。");
			resp.sendRedirect("login");
		}
	}
	
	public void doPost(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException{
		this.doGet(res,resp);
	}
}
