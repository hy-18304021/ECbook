
package command;
import java.util.List;
import dao.OracleConnect;
import dao.*;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import bean.*;
public class BookInfoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		String book_isbn = (String)reqc.getParameter("book_isbn")[0];
		// System.out.println("book_isbn="+book_isbn);

		OracleConnect.getInstance().beginTransaction();
		AbstractDaoFactory daofac = AbstractDaoFactory.getFactory(reqc);
		BookDao bookdao = daofac.getBookDao();
		EbBookBean book = bookdao.getBook(book_isbn);

		List recommendedBook = bookdao.getRecommendedBooks(book.getGenre_id());
		reqc.setRequestAttribute("recommendedBook",recommendedBook);
		// System.out.println(book);



		ReviewDao reviewdao = daofac.getReviewDao();
        List bookreviewlist = reviewdao.getBookReview(book_isbn);
        reqc.setRequestAttribute("bookreviewlist",bookreviewlist);

		// OracleConnect.getInstance().commit();
		OracleConnect.getInstance().closeConnection();
		resc.setResult(book);
		resc.setTarget("bookpage");
		return resc;
	}
}
