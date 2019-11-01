package filter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnector{
	
	Connection cn;
	
	public OracleConnector(String user,String pass){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connectionインターフェイスを実装するクラスをロード
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",user,pass);
			
			System.out.println("接続完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public Connection getCn(){
		return cn;
	}
}