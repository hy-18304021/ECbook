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
		//Map������o��
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

		//�I���N���n��
		OracleConnect.getInstance().beginTransaction();

		//�C���e�O���[�V�������C���̏����Ăяo��
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		UserDao dao=factory.getUserDao();
		int succase=dao.addUser(eb);
		if(succase==0){
			resc.setTarget("register");
			resc.setResult("Redist Failed");
			return resc;
		}
		System.out.println(succase);
		//�R�~�b�g	
		OracleConnect.getInstance().commit();

		//�I���N���I���
		OracleConnect.getInstance().closeConnection();

		LoginCommand logcom=new LoginCommand();
		logcom.init(reqc);
		resc=logcom.execute(resc);
		
		resc.setTarget("registresult");
        return resc;
	}
}