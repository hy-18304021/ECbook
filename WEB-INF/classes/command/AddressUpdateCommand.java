package command;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

import dao.OracleConnect;
import dao.AddressDao;
import dao.AbstractDaoFactory;

import java.util.List;

import bean.EbAddressBean;

public class AddressUpdateCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();
        
        int address_id=Integer.parseInt(reqc.getParameter("address_id")[0]);
        String receiver_name=reqc.getParameter("name")[0];
        String postal_code=reqc.getParameter("code")[0];
        String address=reqc.getParameter("address")[0];
        String tel=reqc.getParameter("tel")[0];

		AbstractDaoFactory daofac=AbstractDaoFactory.getFactory(reqc);
		AddressDao addressdao=daofac.getAddressDao();
        
        EbAddressBean ea=new EbAddressBean();
        ea.setAddress_id(address_id);
        
        OracleConnect.getInstance().beginTransaction();
        EbAddressBean oldinfo=addressdao.getAddress(reqc.getParameter("address_id")[0]);

        if(receiver_name==""){
			ea.setReceiver_name(oldinfo.getReceiver_name());
		}else{
			ea.setReceiver_name(receiver_name);
		}

		if(postal_code==""){
			ea.setPostal_code(oldinfo.getPostal_code());
		}else{
			ea.setPostal_code(Integer.parseInt(postal_code));
		}

		if(address==""){
			ea.setAddress(oldinfo.getAddress());
		}else{
			ea.setAddress(address);
		}

		if(tel==""){
			ea.setTel(oldinfo.getTel());
		}else{
			ea.setTel(tel);
        }
        
        ea.setUser_id(oldinfo.getUser_id());


        //ëóÇËêÊÇÃèÓïÒÇïœçX
        addressdao.upDateAddress(ea);

        List useraddress = addressdao.getUserAddress(oldinfo.getUser_id());
        resc.setResult(useraddress);

        OracleConnect.getInstance().commit();

        OracleConnect.getInstance().closeConnection();

        resc.setTarget("adrmanage");
        return resc;
    }
}