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

        //userid�g����ebsales����f�[�^�擾
        RequestContext reqc=getRequestContext();

        //�I���N���n��
		OracleConnect.getInstance().beginTransaction();

		//�C���e�O���[�V�������C���̏����Ăяo��
        AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
        
        SalesDao dao=factory.getSalesDao();
        String userid=((EbUserBean)reqc.getSessionAttribute("user")).getId();
        List sales=dao.getUserSales(userid);
        
        resc.setResult(sales);

		//�R�~�b�g	
		OracleConnect.getInstance().commit();

        resc.setTarget("orderhistory");
        
        return resc;
    }
}