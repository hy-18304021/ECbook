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

        //�Z�b�V�������l��
        HttpSession session=((HttpServletRequest) req).getSession();

        //�F�؃g�[�N�����擾
        String flag=(String)session.getAttribute("mflag");
        System.out.println("soto");
        System.out.println(flag);
        //�F�؃g�[�N�������邩����
        if(flag==null){
            //HttpServletRequest�^�ɃL���X�g����req������
            HttpServletRequest hreq=(HttpServletRequest)req;

            //���N�G�X�g�̃T�[�u���b�g�p�X���󂯎��
            String servletPath=hreq.getServletPath();

            //�^�[�Q�b�g���\�[�X�̃T�[�u���b�g�p�X��o�^����
            hreq.setAttribute("target",servletPath);

            //�Ȃ��Ȃ烍�O�C����
            RequestDispatcher dip=req.getRequestDispatcher("/WEB-INF/jsp/administrator/mngrlogin.jsp");
            dip.forward(req,res);
        }else{
            //�{����URL��
            chain.doFilter(req,res);
        }
    }
}