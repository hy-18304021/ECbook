package command;

import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import bean.EbBookBean;
import helper.IsbnDataGetter;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class BookRegistCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		//1/16・変数isbnでNullPointerExceptionがでる 治った
		String isbn=(String)reqc.getParameter("book_isbn")[0];
		int id=Integer.parseInt((String)reqc.getParameter("genre_id")[0]);
		int price=Integer.parseInt((String)reqc.getParameter("book_price")[0]);
		int amount=Integer.parseInt((String)reqc.getParameter("book_amount")[0]);
		
		EbBookBean eb=new EbBookBean();

		eb.setBook_isbn(isbn);
		IsbnDataGetter.getIsbnData(eb);
		eb.setBook_amount(amount);
		eb.setBook_price(price);
		eb.setGenre_id(id);

		System.out.println(eb.getBook_amount());
        System.out.println(eb.getBook_price());
        System.out.println(eb.getGenre_id());
        System.out.println(eb.getBook_isbn());
        System.out.println(eb.getBook_name());
        System.out.println(eb.getPublisher());
        System.out.println(eb.getSeries());
        System.out.println(eb.getVolume());
        System.out.println(eb.getAuthor());
    	System.out.println(eb.getRelease_date());
        System.out.println(eb.getAudience());
        System.out.println(eb.getLabel());
        System.out.println(eb.getText_content());

		//オラクル始め
		OracleConnect.getInstance().beginTransaction();

		//インテグレーションレイヤの処理呼び出し
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		BookDao dao=factory.getBookDao();
		dao.addBook(eb);
		
		//コミット	
		OracleConnect.getInstance().commit();
		
		//オラクル終わり
		OracleConnect.getInstance().closeConnction();

        resc.setTarget("administrator/manager");
        return resc;
	}
}