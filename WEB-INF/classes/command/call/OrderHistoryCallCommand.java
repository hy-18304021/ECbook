package command.call;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class OrderHistoryCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        //userid使ってebsalesからデータ取得

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

        resc.setTarget("orderhistory");
        
        return resc;
    }
}