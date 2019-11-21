package filter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnector{
	
	Connection cn;
	
	public OracleConnector(String user,String pass){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
<<<<<<< HEAD
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",user,pass);
=======
			//
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ebtest","ebpass");
>>>>>>> b4016e80a7543f4dcb6fd91e3fdfea5034d7b9f0
			
			System.out.println("Connection complete");
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