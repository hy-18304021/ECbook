package command;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

import dao.OracleConnect;
import dao.AddressDao;
import dao.AbstractDaoFactory;
import java.util.List;

import bean.EbUserBean;

public class AddressUpdateCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();
        
		AbstractDaoFactory daofac=AbstractDaoFactory.getFactory(reqc);
		AddressDao addressdao=daofac.getAddressDao();
        EbUserBean user=(EbUserBean)reqc.getSessionAttribute("user");
        System.out.println(user.getId());
        
        OracleConnect.getInstance().beginTransaction();
        
        //‘—‚èæ‚Ìî•ñ‚ğ•ÏX
        List address = addressdao.getUserAddress(user.getId());
        resc.setResult(address);

        OracleConnect.getInstance().commit();

        OracleConnect.getInstance().closeConnection();

        resc.setTarget("mypage");
        return resc;
    }
}