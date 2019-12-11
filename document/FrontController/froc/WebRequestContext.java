package froc;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class WebRequestContext implements RequestContext{
    private Map _parameters;
    private HttpServletRequest _req;

    public WebRequestContext(){}

    public String getCommandPath(){
        String servletpath=_req.getServletPath();

        String commandpath=servletpath.substring(1);

        return commandpath;
    }

    public String[] getParameter(String key){
        return (String[])_parameters.get(key);
    }

    public Object getSession(){
        return _req.getSession();
    }

    public Object getRequest(){
        return _req;
    }

    public void setRequest(Object request){
        _req=(HttpServletRequest)request;
    	
        _parameters=_req.getParameterMap();
    	
    }
}