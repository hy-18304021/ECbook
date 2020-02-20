package command.call;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class OrderHistoryCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){

        //userid�g����ebsales����f�[�^�擾

        RequestContext reqc=getRequestContext();

        //�I���N���n��
		OracleConnect.getInstance().beginTransaction();

		//�C���e�O���[�V�������C���̏����Ăяo��
        AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
        
        
		BookDao dao=factory.getBookDao();
        List books=dao.getAllBook();
        
        resc.setResult(books);

		//�R�~�b�g	
		OracleConnect.getInstance().commit();

        resc.setTarget("orderhistory");
        
        return resc;
    }
}