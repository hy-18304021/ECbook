package command.call;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class ManagerCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        resc.setTarget("administrator/manager");
        
        return resc;
    }
}