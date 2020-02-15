package command;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class RemoveSelectAddressCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();

        reqc.sessionRemove("address");

		resc.setTarget("checkout");
		return resc;
	}
}