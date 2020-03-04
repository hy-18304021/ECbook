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

        //userid�g����ebsales����f�[�^�擾
        RequestContext reqc=getRequestContext();

        //�I���N���n��
		OracleConnect.getInstance().beginTransaction();

		//�C���e�O���[�V�������C���̏����Ăяo��
        AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
        
        SalesDao salesdao=factory.getSalesDao();
        Sales_RefDao salesrefdao=factory.getSales_RefDao();
        String userid=((EbUserBean)reqc.getSessionAttribute("user")).getId();
        
        //ToDo:���̃��[�U�[��SalesBean�̃��X�g���擾
        ArrayList<EbSalesBean> salesBeans=salesdao.getUserSales(userid);
        for(EbSalesBean sales : salesDaos){
            //ToDo:SalesDao��Sales_RefDao�̃��X�g�B���[�v��
            List sales_RefDaos=salesrefdao.getUserSales_Ref(sales.getBook_isbn());
            sales.setSales_ref()
            //ToDo:Sales_RefDao��BookDao�C���X�^���X
            
        }
        


        resc.setResult(sales);
        reqc.sessionAttribute("sales_ref",sales_ref);

		//�R�~�b�g	
		OracleConnect.getInstance().commit();

        resc.setTarget("orderhistory");
        
        return resc;
    }
}