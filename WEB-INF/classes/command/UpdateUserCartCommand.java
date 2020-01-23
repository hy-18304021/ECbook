package command;

import froc.*;
import dao.*;
import bean.*;
import java.util.ArrayList;

public class UpdateUserCartCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		String user_id=(String)reqc.getParameter("user_id")[0];
		String book_isbn=(String)reqc.getParameter("book_isbn")[0];
		int cart_amount= Integer.parseInt(reqc.getParameter("cart_amount")[0]);
		// System.out.println("user_id="+user_id+"\tbook_isbn="+book_isbn+"\tcart_amount="+cart_amount);

		EbCartBean ec=new EbCartBean();

		ec.setUser_id(user_id);
		ec.setBook_isbn(book_isbn);
		ec.setCart_amount(cart_amount);

		AbstractDaoFactory daofac=AbstractDaoFactory.getFactory(reqc);
		CartDao cartdao=daofac.getCartDao();

		OracleConnect.getInstance().beginTransaction();

		cartdao.updateCart(ec);
		OracleConnect.getInstance().commit();

		ArrayList mycart = cartdao.getUserCartInfo(user_id);
		reqc.sessionAttribute("mycart",mycart);

		resc.setTarget("mycart");
		return resc;
	}
}