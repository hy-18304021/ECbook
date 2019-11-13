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
			
			//select文
			String sql="select * from EBBOOK";

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

			
			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return resList;
		
	}
}