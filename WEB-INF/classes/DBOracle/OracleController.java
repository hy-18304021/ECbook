package DBOracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OracleController{
	private static Connection conn = null;
	private static Statement st = null;
	private static PreparedStatement pstmt=null;
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
	public static Connection connect(String id, String pass){
		try{
			conn=new OracleController(id,pass).getConnection();
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
	// Create new ECBook application's account
	public static int regist(String id,String name,String pass,String tel, String mail, int sex, String birth){
		Connection admin=null;
		int isRegisted=0;
		String sql = "insert into UserTable values('"+id+"','"+name+"','"+pass+"','"+tel+"','"+mail+"','"+sex+"','"+birth+"')";
		try{
			admin = connectAsAdmin();
			admin.setAutoCommit(false);
			st = admin.createStatement();
			int i = st.executeUpdate(sql);  //executeQuery is used for outputting by ResultSet
			if(i==1){
				admin.commit();
				System.out.println("Registed!");
				isRegisted=1;
			}
		}catch(SQLException e){
			System.out.println("This id has already exited!");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,st,rs);
		}
		return isRegisted;
	}

	//
	public static int userCheck(String id, String pass){
		Connection admin = connectAsAdmin();
		int x = -1;
		try{
			pstmt = admin.prepareStatement("select pass from UserTable where id = ?");
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();

			if(rs.next()){
				String realPass = rs.getString("pass");
				if(realPass.equals(pass)){
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

	public static ArrayList getUserInfo(String id){
		ArrayList<Object> information=new ArrayList<>();
		Connection admin = connectAsAdmin();
		try{
			pstmt = admin.prepareStatement("select * from usertable where id = ?");
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();

			if(rs.next()){
				for(int i =1;i<=7;i++){
					information.add(rs.getString(i));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			disconnect(admin,pstmt,rs);
		}
		return information;
	}

	public static void updateUserInfo(){

	}

	public static int registBook(int kind, String name,int price,int count,String id){
		Connection admin=null;
		int isRegisted=0;
		String sql = "insert into EBBook values("+kind+",'"+name+"',"+price+","+count+",'"+id+"')";
		// System.out.println(sql);
		try{
			admin = connectAsAdmin();
			admin.setAutoCommit(false);
			st = admin.createStatement();
			int i = st.executeUpdate(sql);  //executeQuery is used for outputting by ResultSet
			if(i==1){
				admin.commit();
				System.out.println("Registed!");
				isRegisted=1;
			}
		}catch(SQLException e){
			System.out.println("This book has already exited!");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,st,rs);
		}
		return isRegisted;
	}
}
