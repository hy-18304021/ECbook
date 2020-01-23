package command;

import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import java.util.List;

public class BookListCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
        RequestContext reqc=getRequestContext();

        //オラクル始め
		OracleConnect.getInstance().beginTransaction();

		//インテグレーションレイヤの処理呼び出し
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		BookDao dao=factory.getBookDao();
        List books=dao.getAllBook();
        
        resc.setResult(books);

		//コミット	
		OracleConnect.getInstance().commit();

		//オラクル終わり
		OracleConnect.getInstance().closeConnection();

        resc.setTarget("administrator/booklist");        
        return resc;
    }
}