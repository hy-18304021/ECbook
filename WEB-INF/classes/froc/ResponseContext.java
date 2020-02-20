package froc;

public interface ResponseContext{
    public Object getResult();
    public String getTarget();
    public void setResult(Object bean);
    public void setTarget(String transferInfo);
    public void setTarget(String transferInfo, int i);
    public void setResponse(Object obj);
    public Object getResponse();
    public void write();
}