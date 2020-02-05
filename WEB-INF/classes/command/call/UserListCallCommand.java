package command.call;

import dao.OracleConnect;
import dao.UserDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import java.util.List;

public class UserListCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
        RequestContext reqc=getRequestContext();

        //オラクル始め
		OracleConnect.getInstance().beginTransaction();

		//インテグレーションレイヤの処理呼び出し
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		UserDao dao=factory.getUserDao();
        List users=dao.getAllUser();
        
        resc.setResult(users);

		//コミット	
		OracleConnect.getInstance().commit();

		//オラクル終わり
		OracleConnect.getInstance().closeConnection();

        resc.setTarget("administrator/userlist");        
        return resc;
    }
}