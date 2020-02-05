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

        //�I���N���n��
		OracleConnect.getInstance().beginTransaction();

		//�C���e�O���[�V�������C���̏����Ăяo��
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		UserDao dao=factory.getUserDao();
        List users=dao.getAllUser();
        
        resc.setResult(users);

		//�R�~�b�g	
		OracleConnect.getInstance().commit();

		//�I���N���I���
		OracleConnect.getInstance().closeConnection();

        resc.setTarget("administrator/userlist");        
        return resc;
    }
}