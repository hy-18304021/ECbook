package command;

import dao.OracleConnect;
import dao.AddressDao;
import dao.AbstractDaoFactory;
import bean.EbAddressBean;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class AddressAddCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc=getRequestContext();

<<<<<<< HEAD
        String user_id=reqc.getParameter("user_id")[0];//���[�U�[�� 
        String receiver_name=reqc.getParameter("reciver_name")[0];//���l
        int postal_code=Integer.parseInt(reqc.getParameter("postal_code")[0]);//�����X�֔ԍ�
        String address=reqc.getParameter("address")[0];//�����Z��
        String tel=reqc.getParameter("tel")[0];//�����d�b�ԍ�
=======
        String user_id=reqc.getParameter("user_id")[0];//���[�U�[�� 
        String receiver_name=reqc.getParameter("reciver_name")[0];//���l
        int postal_code=Integer.parseInt(reqc.getParameter("postal_code")[0]);//�����X�֔ԍ�
        String address=reqc.getParameter("address")[0];//�����Z��
        String tel=reqc.getParameter("tel")[0];//�����d�b�ԍ�
>>>>>>> 78b960eb7bd1db56145b7d503ce0e0a455335e3f
        
        //bean
		EbAddressBean eb=new EbAddressBean();
        eb.setUser_id(user_id);
        eb.setReceiver_name(receiver_name);
        eb.setPostal_code(postal_code);
        eb.setAddress(address);
        eb.setTel(tel);


<<<<<<< HEAD
		//�I���N���n��
		OracleConnect.getInstance().beginTransaction();

		//�C���e�O���[�V�������C���̏����Ăяo��
=======
		//�I���N���n��
		OracleConnect.getInstance().beginTransaction();

		//�C���e�O���[�V�������C���̏����Ăяo��
>>>>>>> 78b960eb7bd1db56145b7d503ce0e0a455335e3f
		AbstractDaoFactory factory=AbstractDaoFactory.getFactory(reqc);
		AddressDao dao=factory.getAddressDao();
		dao.addAddress(eb);

<<<<<<< HEAD
		//�R�~�b�g	
		OracleConnect.getInstance().commit();

		//�I���N���I���
=======
		//�R�~�b�g	
		OracleConnect.getInstance().commit();

		//�I���N���I���
>>>>>>> 78b960eb7bd1db56145b7d503ce0e0a455335e3f
		OracleConnect.getInstance().closeConnection();

		resc.setTarget("mypage");
        return resc;
	}
}