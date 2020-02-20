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

public class RecommandedBookFilter implements Filter{
    public void init(FilterConfig config)throws ServletException{}
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{
        // System.out.println("RecommandedBookFilter");
        HttpServletRequest hreq = (HttpServletRequest)req;
        RequestContext reqc = new WebRequestContext();
        reqc.setRequest(hreq);

        AbstractDaoFactory daofac =AbstractDaoFactory.getFactory(reqc);
        BookDao bookdao = daofac.getBookDao();

        List recommendedBooks = bookdao.getRecommendedBooks();
        hreq.setAttribute("recommendedBooks",recommendedBooks);

        List recommendedShounen = bookdao.getRecommendedBooks(1);
        hreq.setAttribute("recommendedShounen",recommendedShounen);

        List recommendedShoujo = bookdao.getRecommendedBooks(2);
        hreq.setAttribute("recommendedShoujo",recommendedShoujo);

        List recommendedLightNovel = bookdao.getRecommendedBooks(3);
        hreq.setAttribute("recommendedLightNovel",recommendedLightNovel);

        chain.doFilter(req,res);
    }
}