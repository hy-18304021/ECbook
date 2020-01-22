package command;

import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import bean.EbBookBean;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;


public class GetBookDataCommand extends AbstractCommand{
    @Override
	public ResponseContext execute(ResponseContext resc){
        RequestContext reqc=getRequestContext();
        String isbn=(String)reqc.getParameter("book_isbn")[0];

        EbBookBean eb=null;

        //オラクル始め
		OracleConnect.getInstance().beginTransaction();

		//インテグレーションレイヤの処理呼び出し
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		BookDao dao=factory.getBookDao();
		eb=dao.getBook(isbn);

		//コミット	
		OracleConnect.getInstance().commit();

		//オラクル終わり
		OracleConnect.getInstance().closeConnction();

        //商品ページへ
        resc.setTarget("bookinfo");
        return resc;
    }

}