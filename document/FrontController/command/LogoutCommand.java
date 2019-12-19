package command;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class LogoutCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();

        reqc.sessionRemove();

        //ÉzÅ[ÉÄÇ÷
		resc.setTarget("index");
        return resc;
	}
}