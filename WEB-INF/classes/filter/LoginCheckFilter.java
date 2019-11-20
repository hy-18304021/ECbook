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
        //id?èÔ
        String id=req.getParameter("name");
        //?p?X???[?h?èÔ
        String pass=req.getParameter("pass");

        cn=new OracleConnector("ebtest","ebpass").getCn();
		
		TableReferer tr=new TableReferer(cn);
        //EBUSER????R?[?h?èÔ
        int record=tr.getRecord();

        for(int i=1;i<=record;i++){
            //EBUSER??id??pass???èÔ????
            String dbid=tr.getId(i);
            String dbpass=tr.getPass(i);

            if(dbid!=null&&dbpass!=null){
                ///EBUSER???????????
                //id??pass??`?F?b?N
                if(id.equals(dbid)&&pass.equals(dbpass)){
                    //?F???????F??g?[?N?????Z?b?g
                    HttpSession session=((HttpServletRequest)req).getSession();
                    session.setAttribute("mToken","OK");
                }
            }
        }
        tr.Trclose();
        try{
            cn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        //?{????URL??
        chain.doFilter(req,res);
        
    }
}