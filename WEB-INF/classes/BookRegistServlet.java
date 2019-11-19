import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import DBOracle.OracleController;
import DBOracle.OracleProfile;

import bean.EBBookBean;
import java.util.ArrayList;

public class BookRegistServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		int kind = Integer.parseInt(req.getParameter("book_kind"));
		String name = req.getParameter("book_name");
		int price = Integer.parseInt(req.getParameter("book_price"));
		int count = Integer.parseInt(req.getParameter("book_count"));
		// String image = req.getParameter("book_image");
		String id = req.getParameter("book_isbn");

		String result = "";
		HttpSession session = req.getSession();
		int isRegisted = OracleController.registBook(kind,name,price,count,id);
		if(isRegisted==1){
			result="Registed";
		}else{
			result="This books has already existed!";
		}

		res.setContentType("text/html");
		res.getWriter().write(result);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		doGet(req,res);
	}
}