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
			
			//select文
			String sql="select book_id,book_price,book_count,book_image,book_isbn from EBBOOK";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);
			
			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				
                SelectOracleBean res = new SelectOracleBean();
                //ここから取得
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

			
			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return resList;
		
	}
}