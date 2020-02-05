package command.call;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class MyCartCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        resc.setTarget("mycart");
        
        return resc;
    }
}