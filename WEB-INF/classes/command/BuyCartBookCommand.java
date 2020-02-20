package command;

import dao.OracleConnect;
import dao.CartDao;
import dao.AddressDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import bean.EbCartBean;
import java.util.ArrayList;

//çwì¸Ç∑ÇÈÉRÉ}ÉìÉh
public class BuyCartBookCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();
        
        resc.setTarget("checkout");
        return resc;
	}
}