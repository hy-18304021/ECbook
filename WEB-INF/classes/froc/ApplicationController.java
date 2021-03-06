package froc;

public interface ApplicationController{
    //中に
    //RequestContext rc=new WebRequestContext();
    //rc.setRequest(req);
    RequestContext getRequest(Object request);

    //中に
    //AbstractCommand command=CommandFactory.getCommand(rc);
    //command.init(rc);
    //ResponseContext resc=command.execute();
    ResponseContext handlRequest(RequestContext request);

    //中に
    //req.setAttribute("result",resc.getResult());
    //RequestDispatcher reqd=req.getRequestDispatcher(resc.getTarger());
    //reqd.forward(req,res);
    void handleResponse(RequestContext reqc,ResponseContext resc);
}