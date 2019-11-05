package filter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class TableReferer{
	
	Connection cn=null;
	ResultSet rs=null;
	Statement st=null;
	
	public TableReferer(Connection cn){
		this.cn=cn;
		String sql ="SELECT id,pass FROM EBUSER";
		
		try{
			st=cn.createStatement();
			rs=st.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public String getId(int i){
		String id=null;
		try{
		id=rs.getString(i);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return id;
	}

	public String getPass(int i){
		String pass=null;
		try{
			pass=rs.getString(i);
			}catch(SQLException e){
				e.printStackTrace();
			}
			return pass;
		}

	public int getRecord(){
		int record=0;
		try{
			rs.last();
			record=rs.getRow();
			rs.beforeFirst();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return record;
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