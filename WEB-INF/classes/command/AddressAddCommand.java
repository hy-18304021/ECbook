package command;

import dao.OracleConnect;
import dao.AddressDao;
import dao.AbstractDaoFactory;
import bean.EbAddressBean;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class AddressAddCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();

<<<<<<< HEAD
        String user_id=reqc.getParameter("user_id")[0];//ï¿½ï¿½ï¿½[ï¿½Uï¿½[ï¿½ï¿½ 
        String receiver_name=reqc.getParameter("reciver_name")[0];//ï¿½ï¿½ï¿½l
        int postal_code=Integer.parseInt(reqc.getParameter("postal_code")[0]);//ï¿½ï¿½ï¿½ï¿½ï¿½Xï¿½Ö”Ôï¿½
        String address=reqc.getParameter("address")[0];//ï¿½ï¿½ï¿½ï¿½ï¿½Zï¿½ï¿½
        String tel=reqc.getParameter("tel")[0];//ï¿½ï¿½ï¿½ï¿½ï¿½dï¿½bï¿½Ôï¿½
=======
        String user_id=reqc.getParameter("user_id")[0];//ƒ†[ƒU[–¼ 
        String receiver_name=reqc.getParameter("reciver_name")[0];//ŽóŽæl
        int postal_code=Integer.parseInt(reqc.getParameter("postal_code")[0]);//‘—‚èæ—X•Ö”Ô†
        String address=reqc.getParameter("address")[0];//‘—‚èæZŠ
        String tel=reqc.getParameter("tel")[0];//‘—‚èæ“d˜b”Ô†
>>>>>>> 78b960eb7bd1db56145b7d503ce0e0a455335e3f
        
        //bean
		EbAddressBean eb=new EbAddressBean();
        eb.setUser_id(user_id);
        eb.setReceiver_name(receiver_name);
        eb.setPostal_code(postal_code);
        eb.setAddress(address);
        eb.setTel(tel);


<<<<<<< HEAD
		//ï¿½Iï¿½ï¿½ï¿½Nï¿½ï¿½ï¿½nï¿½ï¿½
		OracleConnect.getInstance().beginTransaction();

		//ï¿½Cï¿½ï¿½ï¿½eï¿½Oï¿½ï¿½ï¿½[ï¿½Vï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Cï¿½ï¿½ï¿½Ìï¿½ï¿½ï¿½ï¿½Ä‚Ñoï¿½ï¿½
=======
		//ƒIƒ‰ƒNƒ‹Žn‚ß
		OracleConnect.getInstance().beginTransaction();

		//ƒCƒ“ƒeƒOƒŒ[ƒVƒ‡ƒ“ƒŒƒCƒ„‚Ìˆ—ŒÄ‚Ño‚µ
>>>>>>> 78b960eb7bd1db56145b7d503ce0e0a455335e3f
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		AddressDao dao=factory.getAddressDao();
		dao.addAddress(eb);

<<<<<<< HEAD
		//ï¿½Rï¿½~ï¿½bï¿½g	
		OracleConnect.getInstance().commit();

		//ï¿½Iï¿½ï¿½ï¿½Nï¿½ï¿½ï¿½Iï¿½ï¿½ï¿½
=======
		//ƒRƒ~ƒbƒg	
		OracleConnect.getInstance().commit();

		//ƒIƒ‰ƒNƒ‹I‚í‚è
>>>>>>> 78b960eb7bd1db56145b7d503ce0e0a455335e3f
		OracleConnect.getInstance().closeConnection();

		resc.setTarget("mypage");
        return resc;
	}
}