package froc;


public abstract class AbstractCommand{
    private RequestContext _reqContext;


    public void init(RequestContext parameters){
        _reqContext=parameters;
    }

    public RequestContext getRequestContext(){
        return _reqContext;
    }

    public abstract ResponseContext execute(ResponseContext resc);
}