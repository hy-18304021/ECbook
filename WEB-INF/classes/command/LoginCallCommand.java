package command;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class LoginCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        resc.setTarget("login");
        
        return resc;
    }
}