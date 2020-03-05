package command;

import bean.EbFavoriteBean;
import com.google.gson.*;
import dao.*;
import froc.*;
import java.util.ArrayList;

public class AddToFavoriteCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		String user_id = (String)reqc.getParameter("user_id")[0];
		String book_isbn = (String)reqc.getParameter("book_isbn")[0];

		EbFavoriteBean favorite = new EbFavoriteBean();
		favorite.setUser_id(user_id);
		favorite.setBook_isbn(book_isbn);


		
		AbstractDaoFactory factory = AbstractDaoFactory.getFactory(reqc);
		FavoriteDao favordao = factory.getFavoriteDao();

		if(favordao.checkFavorite(favorite)){
			resc.setResult(2);
			if((String)reqc.getSessionAttribute("target1")!=null){
				resc.setTarget("bookinfo.do?book_isbn="+book_isbn,1);
				reqc.setRequestAttribute("favoriteresult",2);
				reqc.sessionRemove("target1");
			return resc;
			}
			return resc;
		}

		OracleConnect.getInstance().beginTransaction();
		favordao.addFavorite(favorite);

		OracleConnect.getInstance().commit();

		ArrayList myfavorite = favordao.getUserFavorite(user_id);
		reqc.sessionAttribute("myfavorite",myfavorite);
		// OracleConnect.getInstance().closeConnnection();
		// resc.setTarget("mypage");
		// String result = new Gson().toJson(myfavorite);
		if((String)reqc.getSessionAttribute("target1")!=null){
			resc.setTarget("bookinfo.do?book_isbn="+book_isbn,1);
			reqc.setRequestAttribute("favoriteresult",1);
			reqc.sessionRemove("target1");
			return resc;
		}
		resc.setResult(1);

		return resc;
	}
}