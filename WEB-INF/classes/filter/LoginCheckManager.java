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

public class LoginCheckManager implements Filter{
    private FilterConfig config;
    public void init(FilterConfig config)throws ServletException{
        //‰Šú‰»‚·‚é‚½‚ß‚Ìinit“à‚ÅƒCƒ“ƒXƒ^ƒ“ƒX•Ï”‚Ö‚ÌŠi”[
        this.config=config;
    }
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
     throws IOException,ServletException{

        //idŽæ“¾
        String id=req.getParameter("name");
        //ƒpƒXƒ[ƒhŽæ“¾
        String pass=req.getParameter("pass");

        //‰Šú’lƒpƒ‰ƒ[ƒ^‚ðŽæ“¾‚·‚é
        String mid=config.getInitParameter("ManagerID");
        String mpss=config.getInitParameter("ManagerPass");

        System.out.println(mid);
        System.out.println(mpss);

        if(id!=null&&pass!=null){
            //‰Šú’lƒpƒ‰ƒ[ƒ^‚©‚ç‚Æ‚Á‚Ä‚«‚½
            //ƒ†[ƒU[–¼‚ÆƒpƒXƒ[ƒh‚Ìƒ`ƒFƒbƒN
            if(id.equals(mid)&&pass.equals(mpss)){
                //”FØ‚³‚ê‚½‚ç”FØƒg[ƒNƒ“‚ðƒZƒbƒg
                HttpSession session=((HttpServletRequest)req).getSession();
                session.setAttribute("flag","OK");

                // ArrayList array = OracleController.getAllTableInfo("ebbook");
                // ArrayList<EBBookBean> books =(ArrayList<EBBookBean>) array;
                // session.setAttribute("books",books);

                // ArrayList uarray = OracleController.getAllTableInfo("usertable");
                // ArrayList<OracleProfile> users =(ArrayList<OracleProfile>) uarray;
                // session.setAttribute("users",users);
            }
        }
            
        //–{—ˆ‚ÌURL‚Ö
        chain.doFilter(req,res);
        
    }
}