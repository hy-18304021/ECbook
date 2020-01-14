package froc;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

public class WebApplecationController implements ApplecationController{
    //’†‚É
    //RequestContext rc=new WebRequestContext();
    //rc.setRequest(req);
    public RequestContext getRequest(Object request){
        RequestContext rc=new WebRequestContext();
        rc.setRequest(request);
        return rc;
    }

    //’†‚É
    //AbstractCommand command=CommandFactory.getCommand(rc);
    //command.init(rc);
    //ResponseContext resc=command.execute();
    public ResponseContext handlRequest(RequestContext request){
        AbstractCommand command=CommandFactory.getCommand(request);

        command.init(request);

        ResponseContext resc=command.execute(new WebResponseContext());

        return resc;
    }

    //’†‚É
    //req.setAttribute("result",resc.getResult());
    //RequestDispatcher reqd=req.getRequestDispatcher(resc.getTarger());
    //reqd.forward(req,res);
    public void handleResponse(RequestContext reqc,ResponseContext resc){
        HttpServletRequest req=(HttpServletRequest)reqc.getRequest();
        HttpServletResponse res=(HttpServletResponse)resc.getResponse();

        req.setAttribute("result",resc.getResult());

        RequestDispatcher reqd=req.getRequestDispatcher(resc.getTarget());
        try{
            reqd.forward(req,res);
        }catch(ServletException e){
            e.printStackTrace();
        }catch(IOException  e){
            e.printStackTrace();
        }
    }
}