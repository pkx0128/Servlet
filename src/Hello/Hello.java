package Hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//实现接口Servlet开发Servlet
public class Hello implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("This is Destroy method");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("This is init method");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("This is Service Method!!");
		
//		通过res获取PrintWriter对象
		PrintWriter pw = res.getWriter();
//		向客户端输出数据
		pw.println("This is Service method...");
		
	}

	
}
