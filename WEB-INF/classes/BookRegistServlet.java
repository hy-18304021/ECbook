import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import DBOracle.OracleController;
import DBOracle.OracleProfile;
import java.io.*;
import java.nio.file.Paths;
import javax.servlet.http.Part;

import bean.EBBookBean;
import java.util.ArrayList;

//ñ{èÓïÒí«â¡
public class BookRegistServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		int kind = Integer.parseInt(req.getParameter("book_kind"));
		String name = req.getParameter("book_name");
		int price = Integer.parseInt(req.getParameter("book_price"));
		int count = Integer.parseInt(req.getParameter("book_count"));
		String book_image = req.getParameter("book_image").substring(12);
		String isbn = req.getParameter("book_isbn");
		System.out.println(book_image);

		//Test
		// Part filePart = req.getPart("book_image"); // Retrieves <input type="file" name="file">
  //   	String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
  //   	InputStream fileContent = filePart.getInputStream();
		// System.out.println("Test:fileName="+fileName+",filePart="+filePart);

		String result = "";
		// HttpSession session = req.getSession();
		int isRegisted = OracleController.registBook(kind,name,price,count,isbn,book_image);
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