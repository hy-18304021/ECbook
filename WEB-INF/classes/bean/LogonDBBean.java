package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import work.crypt.SHA256;
import work.crypt.BCrypt;

public class LogonDBBean{

	
	private static LogonDBBean instance = new LogonDBBean();

	//LogonDBBeanをreturnする
	public static LogonDBBean getInstance(){
		return instance;
	}

	private LogonDBBean(){}


	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		return ds.getConnection();
	}

	//会員登録に使うメソッド
	public void insertMember(LogonDataBean member){
		Connection conn = null;
		PreparedStatement pstmt = null;

		SHA256 sha = SHA256.getInsatnce();
		try{
			conn = getConnection();

			String orgPass = member.getPass();
			String shaPass = sha.getSha256(orgPass.getBytes());
			String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());

			pstmt = conn.prepareStatement(
				"insert into member values(?,?,?,?,?,?)");
			pstmt.setString(1,member.getId());
			pstmt.setString(2,bcPass);
			pstmt.setString(3,member.getName());
			
			pstmt.setString(4,member.getTel());
			pstmt.setString(5,member.getBirth());
			pstmt.setString(6,member.getSex());
			pstmt.setString(7,member.getMail());
			pstmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
			if(conn != null) try{conn.close();}catch(SQLException ex){}
		}
	}


	
	public int userCheck(String id,String pass){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x=-1;

		SHA256 sha = SHA256.getInsatnce();
		try{
			conn = getConnection();

			String orgPass = pass;
			String shaPass = sha.getSha256(orgPass.getBytes());

			pstmt = conn.prepareStatement(
				"select pass from member where id = ?");
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();

			if(rs.next()){//当てはまるIDがあれば実行
				String dbpass = rs.getString("pass");
				if(BCrypt.checkpw(shaPass,dbpass))
					x=1;//成功
				else
					x=0;//パスワードが違う
			}else//IDがないとき実行
				x=-1;//IDなし

			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(rs != null) try{rs.close();}catch(SQLException ex){}
				if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
				if(conn != null) try{conn.close();}catch(SQLException ex){}
			}
			return x;
		}

		//同じIDが存在するか判定するメソッド
		public int confirmId(String id){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int x=-1;

			try{
				conn = getConnection();

				pstmt = conn.prepareStatement(
					"select id from member where id = ?");
				pstmt.setString(1,id);
				rs=pstmt.executeQuery();

				if(rs.next())//ID存在
					x=1;//同じIDがある
				else
					x=-1;//同じIDない
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(rs != null) try{rs.close();}catch(SQLException ex){}
				if(pstmt != null) try{pstmt.close();}catch(SQLException ex){}
				if(conn != null) try{conn.close();}catch(SQLException ex){}
			}
			return x;
		}

		//会員情報修正をためにもとの情報を持ってくる
		public LogonDataBean getMember(String id){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			LogonDataBean member = null;

			 try {
	        conn = getConnection();
	            
	        pstmt = conn.prepareStatement(
	        	"select * from member where id = ?");
	        pstmt.setString(1, id);
	        rs = pstmt.executeQuery();
	     
	       if (rs.next()) {
	            	member = new LogonDataBean();
	                member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
	                member.setTel(rs.getString("tel"));
	                member.setBirth(rs.getString("birtg"));
	                member.setSex(rs.getString("sex"));
	                member.setMail(rs.getString("mail"));
	       }
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
		return member;
	}
	
    public LogonDataBean getMember(String id, String pass){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LogonDataBean member=null;
        
        SHA256 sha = SHA256.getInsatnce();
        try {
            conn = getConnection();
            
            String orgPass = pass;
            String shaPass = sha.getSha256(orgPass.getBytes());
            
            pstmt = conn.prepareStatement(
            	"select * from member where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
     
            if (rs.next()) {
            	String dbpass= rs.getString("pass");
            	
				if(BCrypt.checkpw(shaPass,dbpass)){
                  member = new LogonDataBean();
                  member.setId(rs.getString("id"));
				  member.setName(rs.getString("name"));
                  //member.setAddress(rs.getString("address"));
                  member.setTel(rs.getString("tel"));
                  member.setBirth(rs.getString("birtg"));
	              member.setSex(rs.getString("sex"));
	              member.setMail(rs.getString("mail"));
				}
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return member;
    }
    
    
    @SuppressWarnings("resource")
	public int updateMember(LogonDataBean member){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;
        
        SHA256 sha = SHA256.getInsatnce();
        try {
            conn = getConnection();
            
            String orgPass = member.getPass();
            String shaPass = sha.getSha256(orgPass.getBytes());
            
            pstmt = conn.prepareStatement(
                	"select pass from member where id = ?");
            pstmt.setString(1, member.getId());
            rs = pstmt.executeQuery();
                
            if(rs.next()){
				String dbpass= rs.getString("pass"); 
				if(BCrypt.checkpw(shaPass,dbpass)){
                    pstmt = conn.prepareStatement(
                     "update member set name=?,address=?,tel=? "+
                     "where id=?");
                    pstmt.setString(1, member.getName());
                    //pstmt.setString(2, member.getAddress());
                    pstmt.setString(3, member.getTel());
                    pstmt.setString(4, member.getId());
                    pstmt.setString(5,member.getBirth());
					pstmt.setString(6,member.getSex());
					pstmt.setString(7,member.getMail());
                    pstmt.executeUpdate();
                    x= 1;
				}else
					x= 0;
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    
    
    @SuppressWarnings("resource")
	public int deleteMember(String id, String pass){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x=-1;
        
        SHA256 sha = SHA256.getInsatnce();
        try {
			conn = getConnection();
			
			String orgPass = pass;
            String shaPass = sha.getSha256(orgPass.getBytes());

            pstmt = conn.prepareStatement(
            	"select pass from member where id = ?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
			if(rs.next()){
				String dbpass= rs.getString("pass"); 
				if(BCrypt.checkpw(shaPass,dbpass)){
					pstmt = conn.prepareStatement(
            	      "delete from member where id=?");
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();
					x= 1;
				}else
					x= 0;
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
    }
}