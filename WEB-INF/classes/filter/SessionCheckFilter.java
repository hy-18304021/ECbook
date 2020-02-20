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

import bean.*;
import froc.*;
import dao.*;
import java.util.List;
public class SessionCheckFilter implements Filter{
    public void init(FilterConfig config)throws ServletException{}
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
    throws IOException,ServletException{
        HttpServletRequest hreq = (HttpServletRequest)req;
        
        HttpSession session = hreq.getSession();
        if(session.getAttribute("flag")==null){
        	session.setAttribute("target",hreq.getServletPath()+"?"+hreq.getQueryString());
        	// System.out.println(hreq.getServletPath());

        	RequestDispatcher dis = req.getRequestDispatcher("logincall.do");
        	dis.forward(req,res);
        }else{
        	chain.doFilter(req,res);
        }
    }
}