// package bookshop.controller;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.command.CommandAction;  //need change in line 92 96

// Servlet implementation class Controller
// @WebServlet(
// 	urlPatterns ={
// 		"/Controller",
// 		"*.do"
// 	},
// 	initParams={
// 		@WebInitParam(name="propertyConfig",values="commandMapping.properties") //need change
// 	}
// )

public class FrontController extends HttpServlet{
	private static final long serialVersionUID= 1L;  // ???
	private Map<String,Object> commandMap=new HashMap<>();

	public FrontController(){
		super();
	}
	public void init(ServletConfig config) throws ServletException{

		String props = config.getInitParameter("propertyConfig");
		String realFolder ="/property";
		ServletContext context = config.getServletContext();
		String realPath=context.getRealPath(realFolder)+"\\"+props;


		Properties pr = new Properties();
		FileInputStream f = null;
		try{
			f=new FileInputStream(realPath);
			pr.load(f);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(f!=null){
				try{f.close();}catch(IOException ex){}
			}
		}
		Iterator<?> keyIter=pr.keySet().iterator();
		while(keyIter.hasNext()){
			String command =(String)keyIter.next();
			String className=pr.getProperty(command);
			try{
				Class<?> commandClass=Class.forName(className);
				Object commandInstance=commandClass.newInstance();
				commandMap.put(command,commandInstance);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(InstantiationException e){
				e.printStackTrace();
			}catch(IllegalAccessException e){
				e.printStackTrace();
			}
		}
	}

	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		requestPro(req,res);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		requestPro(req,res);
	}

	protected void requestPro(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		String view = null;
		CommandAction com = null;
		try{
			String command=req.getRequestURI();
			if(command.indexOf(req.getContextPath())==0){
				command= command.substring(req.getContextPath().length());
			}
			com=(CommandAction)commandMap.get(command);
			view = com.requestPro(req,res);
		}catch(Throwable e){
			e.printStackTrace();
		}

		req.setAttribute("cont",view);
		RequestDispatcher dis=req.getRequestDispatcher("/index.jsp");
		dis.forward(req,res);
	}
}