
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import DBOracle.OracleController;
import DBOracle.OracleProfile;

public class RegistServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String tel = req.getParameter("tel");
		String mail = req.getParameter("mail");
		int sex = Integer.parseInt(req.getParameter("sex"));
		String birth = req.getParameter("birth");


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

		RequestDispatcher dis = req.getRequestDispatcher("/registresult");
		dis.forward(req,res);
	}
}