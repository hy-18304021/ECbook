package command.call;

import dao.OracleConnect;
import dao.SalesDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

import bean.EbUserBean;

import java.util.List;

public class OrderHistoryCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        //userid使ってebsalesからデータ取得
        RequestContext reqc=getRequestContext();

        //オラクル始め
		OracleConnect.getInstance().beginTransaction();

		//インテグレーションレイヤの処理呼び出し
        AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
        
        SalesDao dao=factory.getSalesDao();
        String userid=((EbUserBean)reqc.getSessionAttribute("user")).getId();
        List sales=dao.getUserSales(userid);
        
        resc.setResult(sales);

		//コミット	
		OracleConnect.getInstance().commit();

        resc.setTarget("orderhistory");
        
        return resc;
    }
}