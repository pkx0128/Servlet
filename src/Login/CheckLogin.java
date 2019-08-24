package Login;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet re=null;
		try {
//		加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/spdb","root","Pankx0128");
			String sql = "SELECT username,passwd FROM users WHERE username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			re = ps.executeQuery();
			System.out.println("Sql 开始");
			System.out.println("验证账号");
//			判断指定用户名和密码
//			if(username.equals(re.getString("username")) && password.equals(re.getString("passwd"))) {
			if(re.next()) {
//				保存登录用户名到Session
				session.setAttribute("username", username);
//				保存登录密码到Session
				session.setAttribute("password", password);
//				设置Session有效时间为30秒
				session.setMaxInactiveInterval(30);
				
				System.out.println("登录成功。。。。");
//				跳转到Welcome页面并且传递username的值
//				resp.sendRedirect("welcome？username="+username+"&password="+password);
//				跳转到Welcome页面
				resp.sendRedirect("welcome");
			}else {
				System.out.println("登录失败。。。。");
				resp.sendRedirect("login");
			}
//			conn.close();
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) {
					conn.close();					
				}
				if(ps!=null) {
					ps.close();
				}
				if(re!=null) {
					re.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}
	
	public void doPost(HttpServletRequest res,HttpServletResponse resp) throws ServletException,IOException{
		this.doGet(res,resp);
	}
}
