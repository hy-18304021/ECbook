//Mapから持ってきたものからかく商品の名前と値段と購入数を所得
//商品の在庫があるかを判定をして1なら購入へ0なら購入できないと返す
//それをPurchaseOracleでebsalesとebsales_refにinsertして
//ebbookにupdateをする

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


		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/manager/booklist.jsp");
		//パラメータをJSPに転送
		dis.forward(req,res);
		
	}
}