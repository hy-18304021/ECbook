package DBOracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import bean.UserInfoBean;
public class UserInformation{
    public static List<UserInfoBean> getResList(String dbid,String pass){
		
        List<UserInfoBean> resList = new ArrayList<UserInfoBean>();
        
        Connection cn=OracleController.connect(dbid,pass);
		
		try{
			
			//select��
			String sql="select * from ebuser";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				UserInfoBean res = new UserInfoBean();
                
                //��������擾
				String id = rs.getString(1);	
				String pas = rs.getString(2);	
				String mail = rs.getString(3);	
				int sex = rs.getInt(4);	
				int birth = rs.getInt(5);	
				res.setId(id);
				res.setPass(pas);
				res.setMail(mail);
				res.setSex(sex);
				res.setBirth(birth);

				resList.add(res);
				
			}

			
			//Oracle����ؒf����
			cn.close();

			System.out.println("�ؒf����");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL�֘A�̗�O�݂����B");
		}catch(Exception e){
			e.printStackTrace();
		}
		return resList;
		
	}
}