package command.call;

import dao.OracleConnect;
import dao.SalesDao;
import dao.Sales_RefDao;
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
        
        SalesDao salesdao=factory.getSalesDao();
        Sales_RefDao salesrefdao=factory.getSales_RefDao();
        String userid=((EbUserBean)reqc.getSessionAttribute("user")).getId();
        
        List sales=salesdao.getUserSales(userid);
        
        resc.setResult(sales);

		//コミット	
		OracleConnect.getInstance().commit();

        resc.setTarget("orderhistory");
        
        return resc;
    }
}