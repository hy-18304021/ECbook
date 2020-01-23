package command;

import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import bean.EbBookBean;
import java.util.List;

public class DeleteBookCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		String book_isbn=(String)reqc.getParameter("book_isbn")[0];

		EbBookBean eb=new EbBookBean();

		eb.setBook_isbn(book_isbn);

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		BookDao dao = factory.getBookDao();

		OracleConnect.getInstance().beginTransaction();
		
		dao.deleteBook(eb);

		List books=dao.getAllBook();
		resc.setResult(books);

		OracleConnect.getInstance().commit();

		OracleConnect.getInstance().closeConnection();

		resc.setTarget("administrator/booklist");
		return resc;
	}
}