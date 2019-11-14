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
    public void init(FilterConfig config)throws ServletException{
        //初期化するためのinit内でインスタンス変数への格納
        this.config=config;
    }
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
     throws IOException,ServletException{

        //id取得
        String id=req.getParameter("name");
        //パスワード取得
        String pass=req.getParameter("pass");

        //初期値パラメータを取得する
        String mid=config.getInitParameter("ManagerID");
        String mpss=config.getInitParameter("ManagerPass");

        System.out.println(mid);
        System.out.println(mpss);

        if(id!=null&&pass!=null){
            //初期値パラメータからとってきた
            //ユーザー名とパスワードのチェック
            if(id.equals(mid)&&pass.equals(mpss)){
                //認証されたら認証トークンをセット
                HttpSession session=((HttpServletRequest)req).getSession();
                session.setAttribute("flag","OK");
            }
        }
            
        //本来のURLへ
        chain.doFilter(req,res);
        
    }
}