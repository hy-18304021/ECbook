
package command;

import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import java.util.List;
import bean.*;

public class SearchBookCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		// reqc.setCharacterEncoding("UTF-8");
		String book_name = reqc.getParameter("book_name")[0];
		// System.out.println(book_name);

		// System.out.println("SearchBookCommand");

		EbBookBean bookbean = new EbBookBean();
		bookbean.setBook_name(book_name);

		OracleConnect.getInstance().beginTransaction();
		AbstractDaoFactory daofac = AbstractDaoFactory.getFactory(reqc);
		BookDao bookdao = daofac.getBookDao();
		List searchedBooks = bookdao.searchBook(bookbean);


		OracleConnect.getInstance().commit();
		OracleConnect.getInstance().closeConnection();


		resc.setResult(searchedBooks);
		resc.setTarget("booklist");

		return resc;
	}
}