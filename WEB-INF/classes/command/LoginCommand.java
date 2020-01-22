package command;

import dao.OracleConnect;
import dao.UserDao;
import dao.AbstractDaoFactory;
import bean.EbUserBean;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

import java.util.ArrayList;

public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		
		//Mapから取り出す
		String id = (String)reqc.getParameter("id")[0];
		String pass = (String)reqc.getParameter("pass")[0];
		//確認
		System.out.println(id+"\t"+pass);
		//bean
		EbUserBean eb=new EbUserBean();

		//オラクル始め
		OracleConnect.getInstance().beginTransaction();

		//インテグレーションレイヤの処理呼び出し
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		UserDao dao=factory.getUserDao();
		eb=dao.getUser(id);

		//コミット	
		OracleConnect.getInstance().commit();

		//オラクル終わり
		OracleConnect.getInstance().closeConnction();

		if(id!=null&&pass!=null){
			if(id.equals(eb.getId())&&pass.equals(eb.getPass())){
				reqc.sessionAttribute();
			}
		}

		resc.setTarget("index");
        return resc;
	}
}