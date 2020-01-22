package command;

import dao.OracleConnect;
import dao.BookDao;
import dao.AbstractDaoFactory;
import bean.EbBookBean;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;


public class GetBookDataCommand extends AbstractCommand{
    @Override
	public ResponseContext execute(ResponseContext resc){
        RequestContext reqc=getRequestContext();
        String isbn=(String)reqc.getParameter("book_isbn")[0];

        EbBookBean eb=null;

        //�I���N���n��
		OracleConnect.getInstance().beginTransaction();

		//�C���e�O���[�V�������C���̏����Ăяo��
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		BookDao dao=factory.getBookDao();
		eb=dao.getBook(isbn);

		//�R�~�b�g	
		OracleConnect.getInstance().commit();

		//�I���N���I���
		OracleConnect.getInstance().closeConnction();

        //���i�y�[�W��
        resc.setTarget("bookinfo");
        return resc;
    }

}