package command;

import dao.OracleConnect;
import dao.UserDao;
import dao.AbstractDaoFactory;
import bean.EbUserBean;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

import java.util.ArrayList;
import dao.*;

public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		
		//Map������o��
		String id = (String)reqc.getParameter("id")[0];
		String pass = (String)reqc.getParameter("pass")[0];
		//�m�F
		System.out.println(id+"\t"+pass);
		//bean
		EbUserBean eb=new EbUserBean();

		//�I���N���n��
		OracleConnect.getInstance().beginTransaction();

		//�C���e�O���[�V�������C���̏����Ăяo��
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
		UserDao dao=factory.getUserDao();
		eb=dao.getUser(id);
		

		if(id!=null&&pass!=null){
			if(id.equals(eb.getId())&&pass.equals(eb.getPass())){
				reqc.sessionAttribute("flag","OK");

				//User's information
				reqc.sessionAttribute("user",eb);

				//User Cart's information
				CartDao cartdao = factory.getCartDao();
				ArrayList mycart = cartdao.getUserCartInfo(id);
				reqc.sessionAttribute("mycart",mycart);
			}
		}
		// OracleConnect.getInstance().commit();

		//�I���N���I���
		// OracleConnect.getInstance().closeConnection();
		resc.setTarget("mypage");
        return resc;
	}
}