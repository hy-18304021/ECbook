package DBOracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertOracle{
    public static void InsertBook(int id,int price,int count,String image,String isbn){
        
        Connection cn=OracleController.connect("info","pro");
		
		try{
			
			//select��
            String sql="insert into EBBOOK(book_id,book_price,book_count,book_image,book_isbn) value("+id+","+price+","+count+","+image+","+isbn+")";

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