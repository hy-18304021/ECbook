import java.util.ArrayList;
import dao.*;
import froc.*;
import bean.*;
import java.util.List;
public class Test {
	public static void main(String[] args){
	
		EbUserBean ebuser=new EbUserBean();
		ebuser.setId("mai");
		ebuser.setName("MaiMai");
		ebuser.setPass("maimai");
		ebuser.setMail("mai@gmail.com");
		ebuser.setBirth("19960705");
		ebuser.setSex(1);

		AbstractDaoFactory daofac = AbstractDaoFactory.getFactory("dao");
		UserDao userdao=daofac.getUserDao();

		OracleConnect.getInstance().beginTransaction();
		userdao.updateUser(ebuser);

		OracleConnect.getInstance().commit();
		OracleConnect.getInstance().closeConnection();
		System.out.println("close");
	}
}