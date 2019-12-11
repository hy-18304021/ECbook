package froc;

public interface RequestContext{
    public String getCommandPath();
    public String[] getParameter(String key);
    public Object getSession();
    public Object getRequest();
    public void setRequest(Object request);
}