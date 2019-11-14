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
        //���������邽�߂�init���ŃC���X�^���X�ϐ��ւ̊i�[
        this.config=config;
    }
    public void destroy(){}
    public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
     throws IOException,ServletException{

        //id�擾
        String id=req.getParameter("name");
        //�p�X���[�h�擾
        String pass=req.getParameter("pass");

        //�����l�p�����[�^���擾����
        String mid=config.getInitParameter("ManagerID");
        String mpss=config.getInitParameter("ManagerPass");

        System.out.println(mid);
        System.out.println(mpss);

        if(id!=null&&pass!=null){
            //�����l�p�����[�^����Ƃ��Ă���
            //���[�U�[���ƃp�X���[�h�̃`�F�b�N
            if(id.equals(mid)&&pass.equals(mpss)){
                //�F�؂��ꂽ��F�؃g�[�N�����Z�b�g
                HttpSession session=((HttpServletRequest)req).getSession();
                session.setAttribute("flag","OK");
            }
        }
            
        //�{����URL��
        chain.doFilter(req,res);
        
    }
}