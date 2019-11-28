package filter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class TableReferer{
	
	Connection cn=null;
	ResultSet rs=null;
	Statement st=null;
	
	public TableReferer(){
		cn=new OracleConnector("ebtest","ebpass").getCn();
	}

	public String getPass(String id){
		String sql ="SELECT pass FROM EBUSER where id='"+id+"'";
		String pass=null;
		System.out.println(sql);

		try{
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			rs.next();
				pass=rs.getString("pass");
			
			System.out.println(pass);
		cn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return pass;
	}
}