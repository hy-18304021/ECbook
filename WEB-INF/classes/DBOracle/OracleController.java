package DBOracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class OracleController{
	private static Connection conn = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private Connection getConnection(){
		return conn;
	}
	private OracleController(String name, String pass){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",name,pass);
			System.out.println("Connected as"+name);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//adminstrator connect to Oracle
	private static final Connection connectAsAdmin(){
		Connection admin = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			admin=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			System.out.println("Connected as Admin");
		}catch(Exception e){
			e.printStackTrace();
		}
		return admin;
	}

	//Normal user connect to Oracle
	public static Connection connect(String id, String password){
		try{
			conn=new OracleController(id,password).getConnection();
			System.out.println("Connected");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	// Disconnect
	public static void disconnect(Connection cn, Statement st, ResultSet rs){
		try{
			if(rs!=null){rs.close();}
			if(st!=null){st.close();}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			try{
				if(cn!=null){
					cn.close();
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
	// Create new Oracle's account
	public static void regist(String id,String password){
		Connection admin=null;

		String sql = "insert into UserTable values('"+id+"','"+password+"')";
		try{
			admin = connectAsAdmin();
			admin.setAutoCommit(false);
			st = admin.createStatement();
			int i = st.executeUpdate(sql);  //executeQuery is used for outputting by ResultSet
			if(i==1){
				admin.commit();
				System.out.println("Registed!");
			}
		}catch(SQLException e){
			System.out.println("This id has already exited!");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,st,rs);
		}
	}

	//
	public static int userCheck(String id, String password){
		Connection admin = connectAsAdmin();
		PreparedStatement pstmt = null;
		int x = -1;
		try{
			pstmt = admin.prepareStatement("select password from UserTable where id = ?");
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();

			if(rs.next()){
				String realPass = rs.getString("password");
				if(realPass.equals(password)){
					x=1;
				}else{
					x=0;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			disconnect(admin,pstmt,rs);
		}

		return x;
	}
}
