package command;

import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import java.util.List;

public class BookListCallCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
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

		//�I���N���I���
		OracleConnect.getInstance().closeConnection();

        resc.setTarget("administrator/booklist");        
        return resc;
    }
}