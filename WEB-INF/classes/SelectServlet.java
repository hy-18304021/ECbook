
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import DBOracle.OracleController;
import DBOracle.OracleProfile;
import java.util.List;
import java.util.ArrayList;

public class SelectServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<ResClreate> plist=getList();
		
		
		//�p�����[�^��JSP�ɓ]����������
		req.setAttribute("resindx",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/Thread");
		
		//�p�����[�^��JSP�ɓ]��
		dis.forward(req,res);
		
	}
	public List<ResClreate> getList(){
		List<ResClreate> plist=QueryTest.getResList();
		
		return plist;
	}
}
