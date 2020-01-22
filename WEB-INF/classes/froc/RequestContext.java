package froc;

public interface RequestContext{
    public String getCommandPath();
    public String[] getParameter(String key);
    public Object getRequest();
    public void setRequest(Object request);
    public void sessionAttribute();
    public void sessionRemove();
    public String getRealPath(String relPath);
}