import javax.servlet.http.HttpServletRequest;
import DBOracle.OracleController;
import DBOracle.OracleProfile;
import bean.*;
import func.*;

import java.util.ArrayList;


public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext req=getRequestContext();
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		HttpSession ss = req.getSession();
		System.out.println(id+"\t"+pass);
		int i = OracleController.userCheck(id,pass);
		String result = "";
		if(i == 0 ){
			result = "Wrong pass";
		}else if( i == -1){
			result = "This ID is not exist.";
		}else {
			result = "Login Completed!";
			OracleProfile user = new OracleProfile();  //xxxx
			user.setAll(OracleController.getUserInfo(id));
			ss.setAttribute("user",user);

			
			ArrayList array = OracleController.getUserCartInfo(id);
			ArrayList<CartBean> mycart=(ArrayList<CartBean>)array;
			ss.setAttribute("mycart",mycart);

			ss.setAttribute("flag","OK");

		}

		ss.setAttribute("result",result);

		resc.setTarget("index");
        return resc;
	}
}