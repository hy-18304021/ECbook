package filter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class TableReferer{
	
	Connection cn=null;
	ResultSet rs=null;
	Statement st=null;
	
	public TableReferer(Connection cn,String id){
		this.cn=cn;
		String sql ="SELECT pass FROM EBUSER WHERE id="+id;
		
		try{
			st=cn.createStatement();
			rs=st.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public String getPass(){
		String pass=null;
		try{
			pass=rs.getString(1);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return pass;
	}

	public void Trclose(){
		try{
		st.close();
		rs.close();
		cn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}