package command;

import froc.*;
import dao.*;
import bean.*;

public class UpdateUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		String id = (String)reqc.getParameter("id")[0];
		String name = (String)reqc.getParameter("name")[0];
		String pass = (String)reqc.getParameter("pass")[0];
		String mail = (String)reqc.getParameter("mail")[0];
		String birth = (String)reqc.getParameter("birth")[0];
		int sex = Integer.parseInt(reqc.getParameter("sex")[0]);
		System.out.println(birth);

		AbstractDaoFactory daofac = AbstractDaoFactory.getFactory("dao");
		UserDao userdao=daofac.getUserDao();

		OracleConnect.getInstance().beginTransaction();
		EbUserBean oldinfo = userdao.getUser(id);

		EbUserBean newebuser=new EbUserBean();
		newebuser.setId(id);

		if(name==""){
			newebuser.setName(oldinfo.getName());
		}else{
			newebuser.setName(name);
		}

		if(pass==""){
			newebuser.setPass(oldinfo.getPass());
		}else{
			newebuser.setPass(pass);
		}

		if(mail==""){
			newebuser.setMail(oldinfo.getMail());
		}else{
			newebuser.setMail(mail);
		}

		if(birth==""){
			newebuser.setBirth(oldinfo.getBirth());
		}else{
			newebuser.setBirth(birth);
		}

		newebuser.setSex(sex);

		userdao.updateUser(newebuser);

		OracleConnect.getInstance().commit();

		reqc.sessionAttribute("user",newebuser);
		resc.setTarget("mypage");
		return resc;
	}
}