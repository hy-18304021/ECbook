要らない



// import java.io.IOException;

// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpSession;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpServlet;
// import DBOracle.*;
// import bean.EBBookBean;

// import java.util.ArrayList;


// public class LoadTableServlet extends HttpServlet{
// 	public void doPost(HttpServletRequest req, HttpServletResponse res)
// 	throws IOException,ServletException{
// 		String tablename=req.getParameter("tablename");
// 		HttpSession session = req.getSession();
// 		ArrayList array = OracleController.getAllTableInfo(tablename);
// 		if("ebbook".equals(tablename.toLowerCase())){
// 			if(session.getAttribute("books")!=null){
// 				session.removeAttribute("books");
// 			}
// 			ArrayList<EBBookBean> books =(ArrayList<EBBookBean>) array;
// 			session.setAttribute("books",books);
// 		}else if("usertable".equals(tablename.toLowerCase())){
// 			if(session.getAttribute("users")!=null){
// 				session.removeAttribute("users");
// 			}
// 			ArrayList<OracleProfile> users = (ArrayList<OracleProfile>)array;
// 			session.setAttribute("users",users);
// 		}

// 		res.setContentType("text/html");
// 		res.getWriter().write("OK");

// 		String thisServletPath= req.getServletPath();
// 		RequestDispatcher dis = req.getRequestDispatcher(thisServletPath);
// 		dis.forward(req,res);
		
// 	}
// 	public void doGet(HttpServletRequest req, HttpServletResponse res)
// 	throws IOException,ServletException{
// 		doPost(req,res);
// 	}
// }
