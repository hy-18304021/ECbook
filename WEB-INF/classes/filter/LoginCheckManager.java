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

public class LoginCheckManager implements Filter{
    private FilterConfig config;
    public void init(FilterConfig config)throws ServletException{}
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
     throws IOException,ServletException{

        //id取得
        String id=req.getParameter("name");
        //パスワード取得
        String pass=req.getParameter("pass");

        if(id=="ECBookM"&&pass=="manager"){
            //認証されたら認証トークンをセット
            HttpSession session=((HttpServletRequest)req).getSession();
            session.setAttribute("manager","OK");
        }
        //本来のURLへ
        chain.doFilter(req,res);
        
    }
}