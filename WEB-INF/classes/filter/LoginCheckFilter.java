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


public class LoginCheckFilter implements Filter{
    private FilterConfig config;
    public void init(FilterConfig config)throws ServletException{}
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
     throws IOException,ServletException{

        //id取得
        String id=req.getParameter("id");
        //パスワード取得
        String pass=req.getParameter("pass");

		
        TableReferer tr=new TableReferer();


        //EBUSERのidとpassを取得する
        String dbpass=tr.getPass(id);
        System.out.println(dbpass);
        System.out.println(pass);

        if(dbpass!=null){
            ///EBUSERからとってきた
            //idとpassのチェック
            System.out.println("ok1");
            if(pass.equals(dbpass)){
                //認証されたら認証トークンをセット
                System.out.println("ok2");
                HttpSession session=((HttpServletRequest)req).getSession();
                session.setAttribute("mToken","OK");
           }
        }

        //本来のURLへ

        chain.doFilter(req,res);
        
    }
}