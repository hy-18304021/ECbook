import java.util.ArrayList;
import dao.*;
import froc.*;
import bean.*;
import java.util.List;
import com.google.gson.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.*;
import com.google.gson.internal.bind.*;
public class Test1{
	public static void main(String[] args){
		EbBookBean bookbean = new EbBookBean();
		bookbean.setBook_name("よ");
		

		OracleConnect.getInstance().beginTransaction();
		// AbstractDaoFactory daofac = AbstractDaoFactory.getFactory(reqc);
		OraBookDao bookdao = new OraBookDao();
		List searchedBooks = bookdao.searchBook(bookbean);


		OracleConnect.getInstance().commit();
		OracleConnect.getInstance().closeConnection();

		EbBookBean book = (EbBookBean)searchedBooks.get(0);
		System.out.println(book.getBook_name());
	}
}