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
        //??????????????????init?g????C??g?X?^??g?X????h?????i?h[
        this.config=config;
    }
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
     throws IOException,ServletException{

        //id???g?
        String id=req.getParameter("name");
        //?p?X???[?h???g?
        String pass=req.getParameter("pass");

        //??????fl?p??????[?^?????g?????
        String mid=config.getInitParameter("ManagerID");
        String mpss=config.getInitParameter("ManagerPass");

        System.out.println(mid);
        System.out.println(mpss);

        if(id!=null&&pass!=null){
            //??????fl?p??????[?^??????????????
            //????[?U?[?????p?X???[?h???`?F?b?N
            if(id.equals(mid)&&pass.equals(mpss)){
                //?hF???????????hF???g?[?N??g???Z?b?g
                HttpSession session=((HttpServletRequest)req).getSession();
                session.setAttribute("mflag","OK");

                // ArrayList array = OracleController.getAllTableInfo("ebbook");
                // ArrayList<EBBookBean> books =(ArrayList<EBBookBean>) array;
                // session.setAttribute("books",books);

                // ArrayList uarray = OracleController.getAllTableInfo("usertable");
                // ArrayList<OracleProfile> users =(ArrayList<OracleProfile>) uarray;
                // session.setAttribute("users",users);
            }
        }
            
        //?{????URL??
        chain.doFilter(req,res);
        
    }
}