package DBOracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CartOutOracle{
    public static void deleteCart(String user){
        
        Connection cn=OracleController.connect("ebtest","ebpass");
		
		try{
			
			//select��
            String sql="Delete from ebcart where user_id='"+user+"'";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			st.executeQuery(sql);
			
			//Oracle����ؒf����
			cn.close();

			System.out.println("�ؒf����");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL�֘A�̗�O�݂����B");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}