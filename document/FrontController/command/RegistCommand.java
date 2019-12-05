import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import DBOracle.OracleController;
import DBOracle.OracleProfile;
import func.*;

public class RegistCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String tel = req.getParameter("tel");
		String mail = req.getParameter("mail");
		int sex = Integer.parseInt(req.getParameter("sex"));
		String birth = req.getParameter("birth");


		String result = "";
		int isRegisted = OracleController.regist(id,name,pass,tel,mail,sex,birth);
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

		resc.setTarget("index");
        return resc;
	}
}