package DBOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import bean.SelectOracleBean;
public class SelectOracle{
    public static List<> getResList(){
		
        List<> resList = new ArrayList<>();
        
        Connection cn=OracleController.connectAsAdmin();
		
		try{
			
			//select��
			String sql="select * from EBBOOK";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				SelectOracleBean res = new SelectOracleBean();
                
                //��������擾
				String time = rs.getString(1);	
				String con = rs.getString(2);	
				String name = rs.getString(3);	
				res.setBook_id();
				res.setBook_price();
				res.setBook_count();
				res.setBook_image();
				res.setBook_name();
				res.setSmall_genre_name();
				res.setLage_genre_name();
				
				resList.add(res);
				
			}

			
			//Oracle����ؒf����
			cn.close();

			System.out.println("�ؒf����");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("�N���X���Ȃ��݂����B");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL�֘A�̗�O�݂����B");
		}catch(Exception e){
			e.printStackTrace();
		}
		return resList;
		
	}
}