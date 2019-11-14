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
        this.config=config;
    }
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
     throws IOException,ServletException{

        //id�擾
        String id=req.getParameter("name");
        //�p�X���[�h�擾
        String pass=req.getParameter("pass");

        String mid=config.getInitParameter("ManagerID");
        String mpss=config.getInitParameter("ManagerPass");
        System.out.println(mid);
        System.out.println(mpss);
        HttpSession session=((HttpServletRequest)req).getSession();
            if(id.equals(mid)&&pass.equals(mpss)){
                System.out.println("naka");
                //�F�؂��ꂽ��F�؃g�[�N�����Z�b�g
            
                session.setAttribute("mToken","OK");
            }
        //�{����URL��
        chain.doFilter(req,res);
        
    }
}