package froc;

public interface ApplecationController{
    //����
    //RequestContext rc=new WebRequestContext();
    //rc.setRequest(req);
    RequestContext getRequest(Object request);

    //����
    //AbstractCommand command=CommandFactory.getCommand(rc);
    //command.init(rc);
    //ResponseContext resc=command.execute();
    ResponseContext handlRequest(RequestContext request);

    //����
    //req.setAttribute("result",resc.getResult());
    //RequestDispatcher reqd=req.getRequestDispatcher(resc.getTarger());
    //reqd.forward(req,res);
    void handleResponse(RequestContext reqc,ResponseContext resc);
}