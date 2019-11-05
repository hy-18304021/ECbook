
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import DBOracle.OracleController;
import DBOracle.OracleProfile;


public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException, ServletException{
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		HttpSession ss = req.getSession();
		int i = OracleController.userCheck(id,password);
		String result = "";
		if(i == 0 ){
			result = "Wrong pass";
		}else if( i == -1){
			result = "This ID is not exist.";
		}else {
			result = "Login Completed!";
			OracleProfile user = new OracleProfile();  //xxxx
			user.setId(id);
			user.setPassword(password);
			ss.setAttribute("user",user);
		}
		ss.setAttribute("flag",i);			//cai bien
		ss.setAttribute("result",result);

		RequestDispatcher dis = req.getRequestDispatcher("/loginresult");
		dis.forward(req,res);
	}

	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException, ServletException{
		doGet(req,res);
	}
}