package command;

import dao.OracleConnect;
import dao.CartDao;
import dao.AddressDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import bean.EbCartBean;
import java.util.ArrayList;
import java.util.List;

//購入確認するコマンド
public class PurchaseConfirmationCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();
        
		AbstractDaoFactory daofac=AbstractDaoFactory.getFactory(reqc);
		CartDao cartdao=daofac.getCartDao();
		AddressDao addressdao=daofac.getAddressDao();
        String user_id=reqc.getParameter("user_id")[0];
        
        OracleConnect.getInstance().beginTransaction();

        System.out.println("length"+reqc.getParameter("book_isbn").length);

        for(int i=0;i<reqc.getParameter("book_isbn").length;i++){
            
            System.out.println(reqc.getParameter("book_isbn")[i]);
            System.out.println(reqc.getParameter("cart_amount")[i]);

            EbCartBean ec=new EbCartBean();

            ec.setUser_id(user_id);
            ec.setBook_isbn(reqc.getParameter("book_isbn")[i]);
            ec.setCart_amount(Integer.parseInt((String)reqc.getParameter("cart_amount")[i]));

            cartdao.updateCart(ec); 
            OracleConnect.getInstance().commit();

        }

		ArrayList mycart = cartdao.getUserCartInfo(user_id);
        reqc.sessionAttribute("mycart",mycart);
        
        //送り先の情報を取得
        List address = addressdao.getUserAddress(user_id);
        resc.setResult(address);

        OracleConnect.getInstance().closeConnection();
        
        resc.setTarget("checkout");
        return resc;
	}
}