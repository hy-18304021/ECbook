package DBOracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertOracle{
    public static void InsertBook(int id,int price,int count,String image,String isbn){
        
        Connection cn=OracleController.connect("info","pro");
		
		try{
			
			//select文
            String sql="insert into EBBOOK(book_id,book_price,book_count,book_image,book_isbn) value("+id+","+price+","+count+","+image+","+isbn+")";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			st.executeQuery(sql);
			
			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}