package DBOracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PurchaseOracle{
    public int checkstock(){
        int stock=0;
        return stock;
    }

    public static void purchasebook(){
        
        Connection cn=OracleController.connect("ebtest","ebpass");
		
		try{
			
			//select��
            String sql1="insert into ebsales values()";
            String sql2="insert into ebsales_ref values()";
            String sql3="update ebbook set  where";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			st.executeQuery(sql1);
			st.executeQuery(sql2);
			st.executeQuery(sql3);
			
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