
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import DBOracle.OracleController;
import DBOracle.OracleProfile;
import DBOracle.SelectOracle;
import bean.SelectOracleBean;

import java.util.List;
import java.util.ArrayList;

public class SelectServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		//データベースからリストをもらいたい
		List<SelectOracleBean> plist=getList();
		
		
		//パラメータをJSPに転送したい↓
		req.setAttribute("resindx",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/");
		
		//パラメータをJSPに転送
		dis.forward(req,res);
		
	}
	public List<SelectOracleBean> getList(){
        String id="info";
        String pass="pro";
		List<SelectOracleBean> plist=SelectOracle.getResList(id,pass);
		
		return plist;
	}
}
