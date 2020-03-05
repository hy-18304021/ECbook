package command;

import dao.*;
import bean.EbUserBean;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

import java.util.ArrayList;
import dao.*;

public class LoginCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();
		
		//Mapから取り出す
		String id = (String)reqc.getParameter("id")[0];
		String pass = (String)reqc.getParameter("pass")[0];
		//確認
		System.out.println(id+"\t"+pass);
		//bean
		EbUserBean eb=new EbUserBean();

		//オラクル始め
		OracleConnect.getInstance().beginTransaction();

		//インテグレーションレイヤの処理呼び出し
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		UserDao dao=factory.getUserDao();
		eb=dao.getUser(id);
		

		if(id!=null&&pass!=null){
			if(id.equals(eb.getId())&&pass.equals(eb.getPass())){
				reqc.sessionAttribute("flag","OK");

				//User's information
				reqc.sessionAttribute("user",eb);

				//User Cart's information
				CartDao cartdao = factory.getCartDao();
				ArrayList mycart = cartdao.getUserCartInfo(id);
				reqc.sessionAttribute("mycart",mycart);

				FavoriteDao favoritedao = factory.getFavoriteDao();
				ArrayList myfavorite = favoritedao.getUserFavorite(id);
				reqc.sessionAttribute("myfavorite",myfavorite);

				String target = (String)reqc.getSessionAttribute("target1");
				if(target==null){
					resc.setTarget("mypage");
				}else{
					int firstequal = target.indexOf("=");
					target = target.substring(0,firstequal+1)+eb.getId()+target.substring(firstequal+1);
					resc.setTarget(target,1);
				}
			}else{
				resc.setTarget("login");
				resc.setResult("Wrong Id or Wrong Pass");
			}
		}

		OracleConnect.getInstance().commit();

		//オラクル終わり
		OracleConnect.getInstance().closeConnection();
		
        return resc;
	}
}