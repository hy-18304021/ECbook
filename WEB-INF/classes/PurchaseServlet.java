//Map���玝���Ă������̂��炩�����i�̖��O�ƒl�i�ƍw����������
//���i�̍݌ɂ����邩�𔻒������1�Ȃ�w����0�Ȃ�w���ł��Ȃ��ƕԂ�
//�����PurchaseOracle��ebsales��ebsales_ref��insert����
//ebbook��update������

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import DBOracle.PurchaseOracle;

public class PurchaseServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{

        Map map=req.getParameterMap();


		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/manager/booklist.jsp");
		//�p�����[�^��JSP�ɓ]��
		dis.forward(req,res);
		
	}
}