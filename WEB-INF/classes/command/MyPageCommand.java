package command;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class MyPageCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        resc.setTarget("mypage");
        
        return resc;
    }
}