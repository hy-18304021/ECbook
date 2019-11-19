package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DBOracle.*;

import bean.*;
import java.util.ArrayList;


public class LoadTableFilter implements Filter{
	private FilterConfig config;
	public void init(FilterConfig config) throws ServletException{
		this.config = config;
	}
	public void destroy(){}
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
	throws IOException,ServletException{
		String servletPath =((HttpServletRequest)req).getServletPath();
		String jspname = servletPath.substring(1,5);
		// System.out.println("servletPath="+servletPath+"\tjspname="+jspname);
		HttpSession session = ((HttpServletRequest)req).getSession();

		if(session.getAttribute("flag")!=null){
			if("book".equals(jspname)){
				ArrayList array = OracleController.getAllTableInfo("ebbook");
            	ArrayList<EBBookBean> books =(ArrayList<EBBookBean>) array;
            	session.removeAttribute("books");
            	session.setAttribute("books",books);
            	session.setAttribute("tablename","ebbook");
			}else if("user".equals(jspname)){
				ArrayList array = OracleController.getAllTableInfo("ebuser");
            	ArrayList<OracleProfile> users =(ArrayList<OracleProfile>) array;
            	session.removeAttribute("users");
            	session.setAttribute("users",users);
            	session.setAttribute("tablename","ebuser");
			}else{
				System.out.println("This table is not exist");
			}
		}

		chain.doFilter(req,res);
	}
}