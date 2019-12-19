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


public class LoginCheckFilter implements Filter{
    private FilterConfig config;
    public void init(FilterConfig config)throws ServletException{}
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
     throws IOException,ServletException{
        HttpSession ss = ((HttpServletRequest)req).getSession();
        if(ss.getAttribute("flag")==null){


        //id取得
            String id=req.getParameter("id");
            //パスワード取得
            String pass=req.getParameter("pass");


            System.out.println(id+"\t"+pass);
            int i = OracleController.userCheck(id,pass);
            String result = "";
            if(i == 0 ){
                result = "Wrong pass";
            }else if( i == -1){
                result = "This ID is not exist.";
            }else {
                result = "Login Completed!";
                OracleProfile user = new OracleProfile();  //xxxx
                user.setAll(OracleController.getUserInfo(id));
                ss.setAttribute("user",user);
                ArrayList array = OracleController.getUserCartInfo(id);
                ArrayList<CartBean> mycart=(ArrayList<CartBean>)array;
                ss.setAttribute("mycart",mycart);
                ss.setAttribute("flag","OK");
            }

            ss.setAttribute("result",result);
        }

        // TableReferer tr=new TableReferer();


        // //EBUSERのidとpassを取得する
        // String dbpass=tr.getPass(id);
        // System.out.println(dbpass);
        // System.out.println(pass);

        // if(dbpass!=null){
        //     ///EBUSERからとってきた
        //     //idとpassのチェック
        //     System.out.println("ok1");
        //     if(pass.equals(dbpass)){
        //         //認証されたら認証トークンをセット
        //         System.out.println("ok2");
        //         HttpSession session=((HttpServletRequest)req).getSession();
        //         session.setAttribute("flag","OK");
        //    }
        // }

        //本来のURLへ

        chain.doFilter(req,res);
        
    }
}