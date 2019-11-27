package DBOracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import bean.SelectOracleBean;
public class SelectOracle{
    public static List<SelectOracleBean> getBookList(String dbid,String pass){
		
        List<SelectOracleBean> resList = new ArrayList<>();
        
        Connection cn=OracleController.connect(dbid,pass);
		
		try{
			
			//select��
			String sql="select book_id,book_price,book_count,book_image,book_isbn from EBBOOK";

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
				int id = rs.getInt(1);	
				int price = rs.getInt(2);	
				int count = rs.getInt(3);	
				String image = rs.getString(4);	
				String isbn = rs.getString(5);	
				res.setBook_id(id);
				res.setBook_price(price);
				res.setBook_count(count);
				res.setBook_image(image);
				res.setBook_isbn(isbn);

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