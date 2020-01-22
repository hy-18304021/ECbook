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


public class AuthenticateManager implements Filter{
    public void init(FilterConfig config)throws ServletException{}
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{

        //セッションを獲得
        HttpSession session=((HttpServletRequest) req).getSession();

        //認証トークンを取得
        String flag=(String)session.getAttribute("mflag");
        System.out.println("soto");
        System.out.println(flag);
        //認証トークンがあるか判定
        if(flag==null){
            //HttpServletRequest型にキャストしてreqを入れる
            HttpServletRequest hreq=(HttpServletRequest)req;

            //リクエストのサーブレットパスを受け取る
            String servletPath=hreq.getServletPath();

            //ターゲットリソースのサーブレットパスを登録する
            hreq.setAttribute("target",servletPath);

            //ないならログインへ
            RequestDispatcher dip=req.getRequestDispatcher("/WEB-INF/jsp/administrator/mngrlogin.jsp");
            dip.forward(req,res);
        }else{
            //本来のURLへ
            chain.doFilter(req,res);
        }
    }
}