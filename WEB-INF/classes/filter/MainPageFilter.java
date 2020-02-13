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

public class MainPageFilter implements Filter{
    public void init(FilterConfig config)throws ServletException{}
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{
        // System.out.println("MainPageFilter");
        HttpServletRequest hreq = (HttpServletRequest)req;
        RequestContext reqc = new WebRequestContext();
        reqc.setRequest(hreq);

        AbstractDaoFactory daofac =AbstractDaoFactory.getFactory(reqc);
        BookDao bookdao = daofac.getBookDao();

        List recommendedBooks = bookdao.getRecommendedBooks();
        hreq.setAttribute("recommendedBooks",recommendedBooks);


        chain.doFilter(req,res);
    }
}