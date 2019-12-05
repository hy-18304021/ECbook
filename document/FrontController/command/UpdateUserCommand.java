import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import DBOracle.OracleController;
import DBOracle.OracleProfile;
import java.util.ArrayList;

public class UpdateUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String mail = req.getParameter("mail");
		String birth = req.getParameter("birth");
		int sex = Integer.parseInt(req.getParameter("sex"));

		String result = "name="+name+"<br>pass="+pass+"<br>mail="+mail+"<br>birth="+birth;
		HttpSession session = req.getSession();
		OracleProfile user=(OracleProfile)session.getAttribute("user");
		String id = user.getId();

		int isUpdated = OracleController.updateUserInfo(id,name,pass,mail,sex,birth);
		if(isUpdated==0){
			result = result+"<br>Fail.";
		}else{
			result = result+"<br>Updated!";
			user.setAll(OracleController.getUserInfo(id));
			session.setAttribute("user",user);
		}

		res.setContentType("text/html");
		res.getWriter().write(result);
	}
}