package command;

import bean.EbFavoriteBean;
import dao.*;
import froc.*;
import java.util.ArrayList;
import com.google.gson.*;
public class DeleteUserFavoriteCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		String user_id = (String)reqc.getParameter("user_id")[0];
		String book_isbn = (String)reqc.getParameter("book_isbn")[0];

		EbFavoriteBean favorite = new EbFavoriteBean();
		favorite.setUser_id(user_id);
		favorite.setBook_isbn(book_isbn);

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory(reqc);
		FavoriteDao favordao = factory.getFavoriteDao();

		OracleConnect.getInstance().beginTransaction();
		favordao.deleteFavorite(favorite);

		OracleConnect.getInstance().commit();

		ArrayList myfavorite = favordao.getUserFavorite(user_id);
		reqc.sessionAttribute("myfavorite",myfavorite);
		// OracleConnect.getInstance().closeConnnection();
		resc.setResult(new Gson().toJson(myfavorite));
		return resc;
	}
}