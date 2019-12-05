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

public class UpdateBookServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		int kind = Integer.parseInt(req.getParameter("book_kind"));
		String name = req.getParameter("book_name");
		String book_image=req.getParameter("book_image").substring(12);
		int price,count;


		if(req.getParameter("book_price")==""){
			price = -1;
		}else if(Integer.parseInt(req.getParameter("book_price"))<1){
			price = -1;
		}else{
			price = Integer.parseInt(req.getParameter("book_price"));
		}

		if(req.getParameter("book_count")==""){
			count = -1;
		}else if(Integer.parseInt(req.getParameter("book_count"))<1){
			count = -1;
		}else{
			count = Integer.parseInt(req.getParameter("book_count"));
		}
		// String image = req.getParameter("book_image");
		String isbn = req.getParameter("book_isbn");

		String result = "kind="+kind+"<br>name="+name+"<br>price="+price+"<br>count="+count;
		HttpSession session = req.getSession();
		int isUpdated = OracleController.updateBook(kind,name,price,count,isbn,book_image);
		if(isUpdated==0){
			result = result+"<br>Fail.";
		}else{
			result = result+"<br>Updated!";
		}

		res.setContentType("text/html");
		res.getWriter().write(result);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		doGet(req,res);
	}
}