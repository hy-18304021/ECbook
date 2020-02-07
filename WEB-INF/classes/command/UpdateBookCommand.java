package command;

import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import bean.EbBookBean;
import java.util.List;

public class UpdateBookCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		String isbn=reqc.getParameter("book_isbn")[0];
		int kind=Integer.parseInt((String)reqc.getParameter("book_kind")[0]);
		int price;
		int amount;

		//オラクル始め
		OracleConnect.getInstance().beginTransaction();

		//インテグレーションレイヤの処理呼び出し
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		BookDao dao=factory.getBookDao();
		EbBookBean eb=dao.getBook(isbn);

		//priceとamountの値がなかったらsqlから値を代入
		if(reqc.getParameter("book_price")[0]==""){
			price = eb.getBook_price();
		}else{
			price = Integer.parseInt((String)reqc.getParameter("book_price")[0]);
		}

		if(reqc.getParameter("book_amount")[0]==""){
			amount = eb.getBook_amount();
		}else{
			amount = Integer.parseInt((String)reqc.getParameter("book_amount")[0]);
		}

		eb.setGenre_id(kind);
		eb.setBook_price(price);
		eb.setBook_amount(amount);

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

		dao.upDateBook(eb);

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