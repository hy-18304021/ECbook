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

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;


public class LoginCheckFilter implements Filter{
    private FilterConfig config;
    public void init(FilterConfig config)throws ServletException{}
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
     throws IOException,ServletException{

        Connection cn=null;
        //id取得
        String id=req.getParameter("name");
        //パスワード取得
        String pass=req.getParameter("pass");

        cn=new OracleConnector("info","pro").getCn();
		
		TableReferer tr=new TableReferer(cn);
        //EBUSERのレコード取得
        int record=tr.getRecord();

        for(int i=0;i>=record;i++){
            //EBUSERのidとpassを取得する
            String dbid=tr.getId(i);
            String dbpass=tr.getPass(i);

            if(dbid!=null&&dbpass!=null){
                ///EBUSERからとってきた
                //idとpassのチェック
                if(id.equals(dbid)&&pass.equals(dbpass)){
                    //認証されたら認証トークンをセット
                    HttpSession session=((HttpServletRequest)req).getSession();
                    session.setAttribute("token","OK");
                }
            }
        }
        tr.Trclose();
        try{
            cn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        //本来のURLへ
        chain.doFilter(req,res);
        
    }
}