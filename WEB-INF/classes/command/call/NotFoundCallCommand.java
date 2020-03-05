package command.call;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class NotFoundCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        resc.setTarget("notfound");
        
        return resc;
    }
}