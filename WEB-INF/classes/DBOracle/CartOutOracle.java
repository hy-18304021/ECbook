package DBOracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CartOutOracle{
    public static void deleteCart(String user){
        
        Connection cn=OracleController.connect("ebtest","ebpass");
		
		try{
			
			//select文
            String sql="Delete from ebcart where user_id='"+user+"'";

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