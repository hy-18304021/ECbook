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


public class BookReviewFilter implements Filter{
    public void init(FilterConfig config)throws ServletException{}
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{
        // System.out.println("BookReviewFilter");
        HttpServletRequest hreq = (HttpServletRequest)req;
        String book_isbn = hreq.getParameter("book_isbn");

        RequestContext reqc = new WebRequestContext();
        reqc.setRequest(hreq);

        AbstractDaoFactory daofac =AbstractDaoFactory.getFactory(reqc);
        ReviewDao reviewdao = daofac.getReviewDao();

        List bookreviewlist = reviewdao.getBookReview(book_isbn);
        hreq.setAttribute("bookreviewlist",bookreviewlist);
        // System.out.println("BookReviewFilter");

        chain.doFilter(req,res);
    }
}