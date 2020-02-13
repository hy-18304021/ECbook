import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import froc.ApplicationController;
import froc.WebApplicationController;
import froc.RequestContext;
import froc.ResponseContext;


public class FrontController extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
        doPost(req,res);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
        req.setCharacterEncoding("UTF-8");

        ApplicationController ap=new WebApplicationController();

        //RequestContext rc=new WebRequestContext();
        //rc.setRequest(req);
        //���
        RequestContext rqc=ap.getRequest(req);
        

        //AbstractCommand command=CommandFactory.getCommand(rc);
        //command.init(rc);
        //ResponseContext resc=command.execute();
        //���

        ResponseContext rsc=ap.handlRequest(rqc);


        //�C���X�^���X�i�[
        rsc.setResponse(res);

        //req.setAttribute("result",resc.getResult());
        //RequestDispatcher reqd=req.getRequestDispatcher(resc.getTarget());
        //reqd.forward(req,res);
        //���

        ap.handleResponse(rqc,rsc);
        
    }
}