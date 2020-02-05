package command.call;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class BookRegistCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        resc.setTarget("administrator/bookregisterform");
        
        return resc;
    }
}