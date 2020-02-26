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

        String user_id=reqc.getParameter("user_id")[0];//ユーザー名 
        String receiver_name=reqc.getParameter("reciver_name")[0];//受取人
        int postal_code=Integer.parseInt(reqc.getParameter("postal_code")[0]);//送り先郵便番号
        String address=reqc.getParameter("address")[0];//送り先住所
        String tel=reqc.getParameter("tel")[0];//送り先電話番号
        
        //bean
		EbAddressBean eb=new EbAddressBean();
        eb.setUser_id(user_id);
        eb.setReceiver_name(receiver_name);
        eb.setPostal_code(postal_code);
        eb.setAddress(address);
        eb.setTel(tel);


		//オラクル始め
		OracleConnect.getInstance().beginTransaction();

		//インテグレーションレイヤの処理呼び出し
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		AddressDao dao=factory.getAddressDao();
		dao.addAddress(eb);

		//コミット	
		OracleConnect.getInstance().commit();

		//オラクル終わり
		OracleConnect.getInstance().closeConnection();

		resc.setTarget("mypage");
        return resc;
	}
}