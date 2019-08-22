package Login;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class LoginOut extends HttpServlet {
	
	public void doGet(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession se = res.getSession();
//		如果Session不为空则清空Session中的值
		if(se.getAttribute("username")!= null) {			
			se.removeAttribute("username");
			se.removeAttribute("password");	
		}
//		退出成功跳转到登录页面
		resp.sendRedirect("login");
		
		
	}
	
	public void doPost(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException{
		this.doGet(res, resp);
	}
}
