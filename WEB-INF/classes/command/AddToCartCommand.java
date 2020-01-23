package command;
import froc.*;
import dao.*;
import bean.*;
import java.util.ArrayList;

public class AddToCartCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		String user_id = (String)reqc.getParameter("user_id")[0];
		String book_isbn = (String)reqc.getParameter("book_isbn")[0];
		int cart_amount = Integer.parseInt(reqc.getParameter("cart_amount")[0]);
		// System.out.println("user_id:"+user_id+"\tbook_isbn:"+book_isbn+"\tcart_amount:"+cart_amount);


		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		CartDao cartdao=factory.getCartDao();

		OracleConnect.getInstance().beginTransaction();

		int amountchecked = cartdao.amountCheck(user_id,book_isbn);

		if(amountchecked==-1){
			EbCartBean cart = new EbCartBean();
			cart.setUser_id(user_id);
			cart.setBook_isbn(book_isbn);
			cart.setCart_amount(cart_amount);

			cartdao.addCart(cart);
		}else{
			cartdao.updateCart(user_id,book_isbn,amountchecked+cart_amount);
		}
		OracleConnect.getInstance().commit();

		ArrayList mycart = cartdao.getUserCartInfo(user_id);
		// OracleConnect.getInstance().closeConnection();
		reqc.sessionAttribute("mycart",mycart);

		resc.setTarget("mycart");
		return resc;
	}
}