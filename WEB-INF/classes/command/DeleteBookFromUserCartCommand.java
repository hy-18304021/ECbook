package command;
import froc.*;
import dao.*;
import bean.*;
import java.util.ArrayList;

public class DeleteBookFromUserCartCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		String user_id=(String)reqc.getParameter("user_id")[0];
		String book_isbn=(String)reqc.getParameter("book_isbn")[0];

		AbstractDaoFactory daofac=AbstractDaoFactory.getFactory();
		CartDao cartdao = daofac.getCartDao();

		OracleConnect.getInstance().beginTransaction();

		cartdao.deleteBook(user_id,book_isbn);
		OracleConnect.getInstance().commit();

		ArrayList mycart = cartdao.getUserCartInfo(user_id);
		reqc.sessionAttribute("mycart",mycart);

		resc.setTarget("mycart");
		return resc;
	}
}