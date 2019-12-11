import dao.OracleConnect;
import dao.UserDao;
import dao.AbstractDaoFactory;
import bean.EbUserBean;
import func.RequestContext;
import func.ResponseContext;
import func.AbstractCommand;

import java.util.ArrayList;

public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		
		//Map������o��
		String id = (String)reqc.getParameter("id")[0];
		String pass = (String)reqc.getParameter("pass")[0];
		//�Z�b�V�����擾
		HttpSession ss = (HttpSession)reqc.getSession();
		//�m�F
		System.out.println(id+"\t"+pass);

		EbUserBean eb=new EbUserBean();

		eb.setId(id);
		eb.setPass(pass);

		OracleConnect.getInsetance().beginTransaction();

		ss.setAttribute("flag","OK");


		ss.setAttribute("result",result);

		resc.setTarget("index");
        return resc;
	}
}