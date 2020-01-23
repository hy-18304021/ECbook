
package command;
import java.util.List;
import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import bean.EbBookBean;;
public class BookInfoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		String book_isbn = (String)reqc.getParameter("book_isbn")[0];
		// System.out.println("book_isbn="+book_isbn);

		OracleConnect.getInstance().beginTransaction();
		AbstractDaoFactory daofac = AbstractDaoFactory.getFactory(reqc);
		BookDao bookdao = daofac.getBookDao();
		EbBookBean book = bookdao.getBook(book_isbn);

		// System.out.println(book);
		OracleConnect.getInstance().commit();
		OracleConnect.getInstance().closeConnection();

		resc.setResult(book);
		resc.setTarget("bookpage");
		return resc;
	}
}
