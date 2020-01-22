package command;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class ProductCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        resc.setTarget("product");
        
        return resc;
    }
}