import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import DBOracle.*;
import bean.EBBookBean;

import java.util.ArrayList;

public class DeleteDataServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		String data = req.getParameter("data");

		HttpSession session = req.getSession();
		String tablename = (String)session.getAttribute("tablename");
		int i = 0;
		if(session.getAttribute("mflag")!=null){
			if(session.getAttribute("tablename")!=null){
				i = OracleController.deleteData(tablename,data);
			}
		}
		if(session.getAttribute("flag")!=null){
			if(session.getAttribute("tablename")!=null){
				String id = ((OracleProfile)session.getAttribute("user")).getId();
				System.out.println("id:"+id);
				i=OracleController.deleteData(tablename,data,id);
			}
		}

		System.out.println("Servlet: tablename=" +tablename);


		String result = "";

		if(i==0){
			result = "Deleting is fail";
		}else if(i==1){
			result = "Deleted";
		}
		// RequestDispatcher dis = req.getRequestDispatcher("/booklist");
		// dis.forward(req,res);
		res.setContentType("text/html");
		res.getWriter().write(result);
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		doPost(req,res);
	}
}