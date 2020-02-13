
package command;
import java.util.List;
import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import bean.EbBookBean;;
public class TestCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
		 System.out.println("TestCommand");

		 resc.setResult(new String("This is result"));

		return resc;
	}
}
