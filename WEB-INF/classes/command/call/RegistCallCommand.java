package command.call;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class RegistCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        resc.setTarget("register");
        
        return resc;
    }
}