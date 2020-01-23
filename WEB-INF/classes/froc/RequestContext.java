package froc;

public interface RequestContext{
    public String getCommandPath();
    public String[] getParameter(String key);
    public Object getRequest();
    public void setRequest(Object request);
    
    public void sessionAttribute(String attributeName,Object status);
    public void sessionRemove(String attributeName);
    public String getPathInfo();

    public String getRealPath(String relPath);

}