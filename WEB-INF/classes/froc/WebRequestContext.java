package froc;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

public class WebRequestContext implements RequestContext{
    private Map _parameters;
    private HttpServletRequest _req;
    private HttpSession _session;


    public WebRequestContext(){}

    public String getCommandPath(){
        String servletpath=_req.getServletPath();
        // System.out.println(servletpath);

        String commandpath=servletpath.substring(1);
        // System.out.println("Commandpath:"+commandpath);


        return commandpath;
    }

    public String[] getParameter(String key){
        return (String[])_parameters.get(key);
    }

    public Object getRequest(){
        return _req;
    }

    public void setRequest(Object request){
        _req=(HttpServletRequest)request;
    	_session=_req.getSession();
        _parameters=_req.getParameterMap();
    	
    }

    public void sessionAttribute(String attributeName, Object status){
        _session.setAttribute(attributeName, status);
    }

    public void sessionRemove(String attributeName){
        _session.removeAttribute(attributeName);
    }
    public String getPathInfo(){
        String servletpath=_req.getServletPath();

        servletpath=servletpath.substring(1);
        String pathInfo=servletpath.substring(servletpath.indexOf("/")+1);
        System.out.println("pathInfo:"+pathInfo);


        return pathInfo;
    }
    public String getRealPath(String relPath){
        return _req.getServletContext().getRealPath(relPath);
    }
}