package command.call;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class AddressEditCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        resc.setTarget("addressedit");
        
        return resc;
    }
}