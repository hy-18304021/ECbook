package command;
import dao.OracleConnect;
import dao.CartDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import bean.EbCartBean;
import java.util.ArrayList;

public class DeleteBookFromUserCartCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		String user_id=(String)reqc.getParameter("user_id")[0];
		String book_isbn=(String)reqc.getParameter("book_isbn")[0];

		EbCartBean ec=new EbCartBean();

		ec.setUser_id(user_id);
		ec.setBook_isbn(book_isbn);

		AbstractDaoFactory daofac=AbstractDaoFactory.getFactory(reqc);
		CartDao cartdao = daofac.getCartDao();

		OracleConnect.getInstance().beginTransaction();

		cartdao.deleteBook(ec);
		OracleConnect.getInstance().commit();

		ArrayList mycart = cartdao.getUserCartInfo(user_id);
		reqc.sessionAttribute("mycart",mycart);

		OracleConnect.getInstance().closeConnection();
		// resc.setResult("Delete OK");
		// resc.setTarget("mycart");
		return resc;
	}
}