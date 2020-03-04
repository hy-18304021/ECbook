package command.call;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

import dao.OracleConnect;
import dao.AddressDao;
import dao.AbstractDaoFactory;
import java.util.List;

import bean.EbUserBean;

public class AddressManagementCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();
        
		AbstractDaoFactory daofac=AbstractDaoFactory.getFactory(reqc);
		AddressDao addressdao=daofac.getAddressDao();
        EbUserBean user=(EbUserBean)reqc.getSessionAttribute("user");
        System.out.println(user.getId());
        
        OracleConnect.getInstance().beginTransaction();
        
        //‘—‚èæ‚Ìî•ñ‚ğæ“¾
        List address = addressdao.getUserAddress(user.getId());
        resc.setResult(address);

        OracleConnect.getInstance().commit();

        OracleConnect.getInstance().closeConnection();

        resc.setTarget("adrmanage");
        return resc;
    }
}