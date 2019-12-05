import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

import DBOracle.*;
import bean.*;
import java.util.ArrayList;

public class UpdateUserCartCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		HttpSession session=req.getSession();
		int cart_amount=Integer.parseInt(req.getParameter("cart_amount"));
		String bookname=req.getParameter("bookname");
		String id = ((OracleProfile)session.getAttribute("user")).getId();

		int isUpdated = OracleController.updateUserCart(id,bookname,cart_amount);
		String result="";
		if(isUpdated==0){
			result = result+"<br>Fail.";
		}else{
			result = result+"<br>Updated!";
		}

		res.setContentType("text/html");
		res.getWriter().write(result);
	}
}