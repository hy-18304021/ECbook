package froc;

public interface RequestContext{
    public String getCommandPath();
    public String[] getParameter(String key);
    public Object getRequest();
    public void setRequest(Object request);

    public Object getSessionAttribute(String attributeName);
    public void sessionAttribute(String attributeName,Object status);
    public void sessionRemove(String attributeName);

    public void setRequestAttribute(String attributeName, Object status);

   	public String getQueryString();
    public String getRealPath(String relPath);
    public boolean checkAjax();

}