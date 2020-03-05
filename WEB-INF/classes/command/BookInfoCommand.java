
package command;
import java.util.List;
import java.util.ArrayList;
import dao.OracleConnect;
import dao.*;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import bean.*;
import com.google.gson.*;
public class BookInfoCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		String book_isbn = (String)reqc.getParameter("book_isbn")[0];
		// System.out.println("book_isbn="+book_isbn);

		OracleConnect.getInstance().beginTransaction();
		AbstractDaoFactory daofac = AbstractDaoFactory.getFactory(reqc);
		BookDao bookdao = daofac.getBookDao();
		EbBookBean book = bookdao.getBook(book_isbn);

		if(book.getBook_isbn()!=null){

			List recommendedBook = bookdao.getRecommendedBooks(book.getGenre_id());
			reqc.setRequestAttribute("recommendedBook",recommendedBook);
			// System.out.println(book);



			ReviewDao reviewdao = daofac.getReviewDao();
			List bookreviewlist = reviewdao.getBookReview(book_isbn);
			reqc.setRequestAttribute("bookreviewlist",bookreviewlist);
			
			
			// OracleConnect.getInstance().commit();
			OracleConnect.getInstance().closeConnection();
			

			if(reqc.checkAjax()){
				resc.setResult(new Gson().toJson(book));

				return resc;
			}
			resc.setResult(book);
			resc.setTarget("bookpage");
			return resc;
		}else{
			String error="この商品はありません";
			String href="indexcall.do";
			String mes="トップへ";
			ArrayList<String> errors=new ArrayList<String>();
			errors.add(error);
			errors.add(href);
			errors.add(mes);
			resc.setResult(errors);
			resc.setTarget("error");
			return resc;
		}
	}
}
