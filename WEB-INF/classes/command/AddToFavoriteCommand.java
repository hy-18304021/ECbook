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
		if((String)reqc.getSessionAttribute("target")!=null){
			resc.setTarget("addedfavor");
			resc.setResult(favorite);
			return resc;
		}
		resc.setResult(1);

		return resc;
	}
}