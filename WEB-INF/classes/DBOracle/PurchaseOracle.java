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
			
			//select文
            String sql1="insert into ebsales values()";
            String sql2="insert into ebsales_ref values()";
            String sql3="update ebbook set  where";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			st.executeQuery(sql1);
			st.executeQuery(sql2);
			st.executeQuery(sql3);
			
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