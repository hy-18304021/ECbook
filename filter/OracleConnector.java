package filter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnector{
	
	Connection cn;
	
	public OracleConnector(String user,String pass){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connection�C���^�[�t�F�C�X����������N���X�����[�h
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",user,pass);
			
			System.out.println("�ڑ�����");
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