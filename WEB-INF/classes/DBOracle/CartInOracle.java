package DBOracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CartInOracle{
    public static void insertCart(String user,String isbn,int zaiko){
        
        Connection cn=OracleController.connect("ebtest","ebpass");
		
		try{
			
			//select文
            String sql="insert into EBCart values("+user+","+isbn+","+zaiko+")";

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