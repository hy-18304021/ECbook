package DBOracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CartInOracle{
    public static void insertCart(String user,String isbn,int zaiko){
        
        Connection cn=OracleController.connect("ebtest","ebpass");
		
		try{
			
			//select��
            String sql="insert into EBCart values("+user+","+isbn+","+zaiko+")";

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