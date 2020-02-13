
package command;

import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import java.util.List;

public class GetBookTableCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		// System.out.println("TakeBookTableCommand");
		OracleConnect.getInstance().beginTransaction();
		// AbstractDaoFactory dao = (OraBookDao)AbstractDaoFactory.getFactory("bookdao");
		AbstractDaoFactory daofac = AbstractDaoFactory.getFactory(reqc);
		BookDao bookdao = daofac.getBookDao();
		List booklist = bookdao.getAllBook();

		OracleConnect.getInstance().commit();
		OracleConnect.getInstance().closeConnection();
		
		resc.setResult(booklist);
		resc.setTarget("booklist");

		return resc;
	}
}