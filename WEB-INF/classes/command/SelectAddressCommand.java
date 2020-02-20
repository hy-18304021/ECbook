package command;

import dao.OracleConnect;
import dao.AddressDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import java.util.List;

public class SelectAddressCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();
        
		String user = reqc.getParameter("user_id")[0];

        OracleConnect.getInstance().beginTransaction();
        
		AbstractDaoFactory daofac = AbstractDaoFactory.getFactory(reqc);
		AddressDao addressDao = daofac.getAddressDao();
        
        List address = addressDao.getUserAddress(user);

		OracleConnect.getInstance().commit();
		OracleConnect.getInstance().closeConnection();

        resc.setResult(address);
        reqc.sessionAttribute("address","adr");

		resc.setTarget("checkout");
		return resc;
	}
}