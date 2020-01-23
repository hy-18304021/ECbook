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
		
		EbCartBean cart = new EbCartBean();

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory(reqc);
		CartDao cartdao=factory.getCartDao();

		OracleConnect.getInstance().beginTransaction();

		//ä˘Ç…ìoò^Ç≥ÇÍÇƒÇΩÇÁÇªÇÃêîó Ç™ï‘ÇËÅAÇ≥ÇÍÇƒÇ»Ç©Ç¡ÇΩÇÁ-1Ç™Ç©Ç¶ÇÈ
		int amountchecked = cartdao.amountCheck(user_id,book_isbn);

		if(amountchecked==-1){
			cart.setUser_id(user_id);
			cart.setBook_isbn(book_isbn);
			cart.setCart_amount(cart_amount);
			cartdao.addCart(cart);
		}else{
			cart.setUser_id(user_id);
			cart.setBook_isbn(book_isbn);
			cart.setCart_amount(amountchecked+cart_amount);
			cartdao.updateCart(cart);
		}
		OracleConnect.getInstance().commit();

		OracleConnect.getInstance().closeConnection();

		ArrayList mycart = cartdao.getUserCartInfo(user_id);
		// OracleConnect.getInstance().closeConnection();
		reqc.sessionAttribute("mycart",mycart);

		resc.setTarget("mycart");
		return resc;
	}
}