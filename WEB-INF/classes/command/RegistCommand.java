package command;

import dao.OracleConnect;
import dao.UserDao;
import dao.AbstractDaoFactory;
import bean.EbUserBean;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class RegistCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		//Mapから取り出す
		String id = (String)reqc.getParameter("id")[0];
		String name = (String)reqc.getParameter("name")[0];
		String pass = (String)reqc.getParameter("pass")[0];
		String mail = (String)reqc.getParameter("mail")[0];
		int sex = Integer.parseInt((String)reqc.getParameter("sex")[0]);
		String birth = (String)reqc.getParameter("birth")[0];

		//bean
		EbUserBean eb=new EbUserBean();

		eb.setId(id);
		eb.setName(name);
		eb.setPass(pass);
		eb.setMail(mail);
		eb.setSex(sex);
		eb.setBirth(birth);

		//オラクル始め
		OracleConnect.getInstance().beginTransaction();

		//インテグレーションレイヤの処理呼び出し
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		UserDao dao=factory.getUserDao();
		dao.addUser(eb);

		//コミット	
		OracleConnect.getInstance().commit();

		//オラクル終わり
		OracleConnect.getInstance().closeConnction();

		resc.setTarget("login");
        return resc;
	}
}