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

        //id�擾
        String id=req.getParameter("id");
        //�p�X���[�h�擾
        String pass=req.getParameter("pass");

		
        TableReferer tr=new TableReferer();


        //EBUSER��id��pass���擾����
        String dbpass=tr.getPass(id);
        System.out.println(dbpass);
        System.out.println(pass);

        if(dbpass!=null){
            ///EBUSER����Ƃ��Ă���
            //id��pass�̃`�F�b�N
            System.out.println("ok1");
            if(pass.equals(dbpass)){
                //�F�؂��ꂽ��F�؃g�[�N�����Z�b�g
                System.out.println("ok2");
                HttpSession session=((HttpServletRequest)req).getSession();
                session.setAttribute("mToken","OK");
           }
        }

        //�{����URL��

        chain.doFilter(req,res);
        
    }
}