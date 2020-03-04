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
        
        OracleConnect.getInstance().beginTransaction();
        
        //�����̏����擾
        List address = addressdao.getUserAddress(user.getId());
        
        OracleConnect.getInstance().commit();

        OracleConnect.getInstance().closeConnection();
        
        resc.setResult(address);

        resc.setTarget("adrmanage");
        return resc;
    }
}