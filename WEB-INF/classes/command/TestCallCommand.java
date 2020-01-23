package command;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class TestCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        resc.setTarget("test");
        
        return resc;
    }
}