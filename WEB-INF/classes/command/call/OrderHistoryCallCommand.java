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
        
        //ToDo:このユーザーのSalesBeanのリストを取得
        ArrayList<EbSalesBean> salesBeans=salesdao.getUserSales(userid);
        for(EbSalesBean sales : salesDaos){
            //ToDo:SalesDaoにSales_RefDaoのリスト。ループ回す
            List sales_RefDaos=salesrefdao.getUserSales_Ref(sales.getBook_isbn());
            sales.setSales_ref()
            //ToDo:Sales_RefDaoにBookDaoインスタンス
            
        }
        


        resc.setResult(sales);
        reqc.sessionAttribute("sales_ref",sales_ref);

		//コミット	
		OracleConnect.getInstance().commit();

        resc.setTarget("orderhistory");
        
        return resc;
    }
}