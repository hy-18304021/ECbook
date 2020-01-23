//Index.jsp page command.

package command;
import java.util.List;
import dao.*;
import froc.*;

public class GetBookTableCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		// System.out.println("TakeBookTableCommand");
		OracleConnect.getInstance().beginTransaction();
		// AbstractDaoFactory dao = (OraBookDao)AbstractDaoFactory.getFactory("bookdao");
		AbstractDaoFactory daofac = AbstractDaoFactory.getFactory();
		BookDao bookdao = daofac.getBookDao();
		List booklist = bookdao.getAllBook();

		// OracleConnect.getInstance().commit();
		// OracleConnect.getInstance().closeConnection();
		resc.setResult(booklist);
		resc.setTarget("booklist");

		return resc;
	}
}