package command;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class BookListCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        resc.setTarget("administrator/booklist");
        
        return resc;
    }
}