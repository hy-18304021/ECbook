import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import DBOracle.OracleController;
import DBOracle.OracleProfile;
import func.*;

public class RegistCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		String id = reqc.getParameter("id");
		String name = reqc.getParameter("name");
		String pass = reqc.getParameter("pass");
		String mail = reqc.getParameter("mail");
		int sex = Integer.parseInt(reqc.getParameter("sex"));
		String birth = reqc.getParameter("birth");


		String result = "";
		int isRegisted = OracleController.regist(id,name,pass,mail,sex,birth);
		if(isRegisted==1){
			result="Registed";
		}else{
			result="This id has already existed!";
		}
		req.setAttribute("result",result);

		OracleProfile oc = new OracleProfile();
		oc.setAll(OracleController.getUserInfo(id));

		HttpSession ss = req.getSession();
		ss.setAttribute("user",oc);

		resc.setTarget("");
        return resc;
	}
}