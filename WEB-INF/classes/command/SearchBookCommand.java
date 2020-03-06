
package command;

import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import java.util.List;
import java.util.ArrayList;
import bean.*;
import com.google.gson.*;
import escape.Escape;
public class SearchBookCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		// reqc.setCharacterEncoding("UTF-8");
		String book_name = reqc.getParameter("book_name")[0];
		book_name = Escape.wholeEscape(book_name);
		int genre_id = Integer.parseInt(reqc.getParameter("genre_id")[0]);
		// System.out.println(book_name+"\t"+genre_id);

		// System.out.println("SearchBookCommand");

		if(genre_id>3){
			String error="このジャンルは存在しません";
			String href="indexcall.do";
			String mes="トップページへ";
			ArrayList<String> errors=new ArrayList<String>();
			errors.add(error);
			errors.add(href);
			errors.add(mes);
			resc.setResult(errors);
			resc.setTarget("error");
			return resc;     
		}

		EbBookBean bookbean = new EbBookBean();
		bookbean.setBook_name(book_name);
		bookbean.setGenre_id(genre_id);

		OracleConnect.getInstance().beginTransaction();
		AbstractDaoFactory daofac = AbstractDaoFactory.getFactory(reqc);
		BookDao bookdao = daofac.getBookDao();
		List searchedBooks = bookdao.searchBook(bookbean);


		OracleConnect.getInstance().commit();
		OracleConnect.getInstance().closeConnection();

		// Gson gson = new Gson();
		resc.setResult(searchedBooks);
		resc.setTarget("booklist");
		return resc;
	}
}