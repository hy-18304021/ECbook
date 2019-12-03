package DBOracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.InputStream;
import bean.*;
import java.sql.Blob;

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
			admin=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ebtest","ebpass");
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
	public static int regist(String id,String name,String pass, String mail, int sex, String birth){
		Connection admin=null;
		int isRegisted=0;
		String sql = "insert into ebuser values('"+id+"','"+name+"','"+pass+"','"+mail+"',"+sex+",'"+birth+"')";
		System.out.println(sql);
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
			try{
				admin.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
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
			pstmt = admin.prepareStatement("select pass from ebuser where id = ?");
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
			pstmt = admin.prepareStatement("select * from ebuser where id = ?");
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();

			if(rs.next()){
				for(int i =1;i<=6;i++){
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

	public static int updateUserInfo(String id,String name,String pass, String mail, int sex, String birth){
		Connection admin = null;
		int isUpdated=0;
		String sql = "update ebuser set sex = "+sex;
		if(name!=""){
			sql =sql+",name='"+name+"'";
		}
		if(pass!=""){
			sql = sql+",pass='"+pass+"'";
		}
		if(mail!=""){
			sql = sql+",mail='"+mail+"'";
		}
		if(birth!=""){
			sql = sql+",birth='"+birth+"'";
		}

		sql=sql+" where id='"+id+"'";
		System.out.println(sql);
		try{
			admin = connectAsAdmin();

			admin.setAutoCommit(false);
			st = admin.createStatement();
			int i = st.executeUpdate(sql);  //executeQuery is used for outputting by ResultSet
			if(i==1){
				admin.commit();
				System.out.println("Updated");
				isUpdated=1;
			}
		}catch(SQLException e){
			try{
				admin.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			System.out.println("Updating was fail...");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,st,rs);
		}
		return isUpdated;
	}

	public static int registBook(int kind, String name,int price,int count,String isbn,String book_image){
		Connection admin=null;
		int isRegisted=0;
		String sql = "insert into EBBook(kind,name,price,count,isbn,book_image) values(?,?,?,?,?,?)";
		System.out.println(sql);
		try{
			admin = connectAsAdmin();
			admin.setAutoCommit(false);
			pstmt = admin.prepareStatement(sql);
			pstmt.setInt(1,kind);
			pstmt.setString(2,name);
			pstmt.setInt(3,price);
			pstmt.setInt(4,count);
			pstmt.setString(5,isbn);
			pstmt.setString(6,book_image);

			isRegisted=pstmt.executeUpdate();
			admin.commit();
		}catch(SQLException e){
			try{
				admin.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			System.out.println("This book has already exited!");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,pstmt,rs);
		}
		return isRegisted;
	}

	public static int deleteData(String tablename, String data){
		Connection admin=null;
		int isDeleted=0;
		String sql = "";
		if("ebbook".equals(tablename)){
			sql = "delete from " +tablename+" where isbn='"+data+"'";
		}else if("ebuser".equals(tablename)){
			sql = "delete from " +tablename+" where id='"+data+"'";
		}
		System.out.println(sql);
		try{
			admin = connectAsAdmin();

			admin.setAutoCommit(false);
			st = admin.createStatement();
			int i = st.executeUpdate(sql);  //executeQuery is used for outputting by ResultSet
			if(i==1){
				admin.commit();
				System.out.println("Deleted");
				isDeleted=1;
			}
		}catch(SQLException e){
			try{
				admin.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			System.out.println("Deleting was fail...");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,st,rs);
		}
		return isDeleted;
	}
	public static int deleteData(String tablename, String data,String id){
		Connection admin=null;
		int isDeleted=0;
		String sql = "";
		if("ebcart".equals(tablename)){
			sql = "delete from "+tablename+" where book_isbn=(select isbn from ebbook where name='"+data+"') and user_id='"+id+"'";
		}
		System.out.println(sql);
		try{
			admin = connectAsAdmin();

			admin.setAutoCommit(false);
			st = admin.createStatement();
			int i = st.executeUpdate(sql);  //executeQuery is used for outputting by ResultSet
			if(i==1){
				admin.commit();
				System.out.println("Deleted");
				isDeleted=1;
			}
		}catch(SQLException e){
			try{
				admin.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			System.out.println("Deleting was fail...");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,st,rs);
		}
		return isDeleted;
	}

	public static int updateBook(int kind, String name,int price,int count,String isbn,String book_image){
		Connection admin = null;
		int isUpdated=0;
		String sql = "update ebbook set kind="+kind;
		if(name!=""){
			sql =sql+",name='"+name+"'";
		}
		if(price!=-1){
			sql = sql+",price="+price;
		}
		if(count!=-1){
			sql = sql+",count="+count;
		}
		if(book_image!=""){
			sql=sql+",book_image='"+book_image+"'";
		}
		sql=sql+" where isbn='"+isbn+"'";
		System.out.println(sql);
		try{
			admin = connectAsAdmin();

			admin.setAutoCommit(false);
			st = admin.createStatement();
			int i = st.executeUpdate(sql);  //executeQuery is used for outputting by ResultSet
			if(i==1){
				admin.commit();
				System.out.println("Updated");
				isUpdated=1;
			}
		}catch(SQLException e){
			try{
				admin.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			System.out.println("Updating was fail...");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,st,rs);
		}
		return isUpdated;
	}

	public static ArrayList getAllTableInfo(String tablename){
		//Runtime Exception!!
		Connection admin = null;
		ArrayList array = new ArrayList();
		String sql = "select * from "+tablename;
		System.out.println(sql);
		try{
			admin = connectAsAdmin();
			st = admin.createStatement();
			rs = st.executeQuery(sql);
			if("ebbook".equals(tablename.toLowerCase())){
				while(rs.next()){
					EBBookBean book = new EBBookBean();
					book.setBook_kind(rs.getInt("kind"));
					book.setBook_name(rs.getString("name"));
					book.setBook_price(rs.getInt("price"));
					book.setBook_count(rs.getInt("count"));
					book.setBook_isbn(rs.getString("isbn"));
					book.setBook_image(rs.getString("book_image"));
					// System.out.println(rs.getInt(1)+rs.getString(2)+rs.getInt(3)+rs.getInt(4)+rs.getString(5));
					array.add(book);
				}
			}else if("ebuser".equals(tablename.toLowerCase())){
				while(rs.next()){
					OracleProfile user = new OracleProfile();
					user.setId(rs.getString("id"));
					user.setName(rs.getString("name"));
					user.setPass(rs.getString("pass"));
					// user.setTel(rs.getString(4));
					user.setMail(rs.getString("mail"));
					user.setSex(rs.getInt("sex"));
					user.setBirth(rs.getString("birth"));
					array.add(user);
				}
			}else{
				System.out.println("Table name is not existed");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,st,rs);
		}
		return array;
	}

	public static ArrayList getUserCartInfo(String userid){
		Connection admin = null;
		ArrayList array = new ArrayList();
		String sql = "select c.user_id, b.name, c.cart_amount FROM ebcart c join ebbook b on c.book_isbn=b.isbn where user_id='"+userid+"'";
		System.out.println(sql);
		try{
			admin = connectAsAdmin();
			st = admin.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				CartBean cart = new CartBean();
				cart.setUser_id(rs.getString("user_id"));
				cart.setBook_name(rs.getString("name"));
				cart.setCart_amount(rs.getInt("cart_amount"));
				System.out.println(rs.getString("user_id")+rs.getString("name")+rs.getInt("cart_amount"));
				array.add(cart);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,st,rs);
		}
		return array;
	}

	public static int updateUserCart(String id, String bookname, int cart_amount){
		Connection admin=null;
		int isUpdated = 0;
		String sql ="update ebcart set cart_amount ="+cart_amount+" where user_id='"+id+"' and book_isbn=(select isbn from ebbook where name='"+bookname+"')";
		System.out.println(sql);
		try{
			admin=connectAsAdmin();
			admin.setAutoCommit(false);
			st=admin.createStatement();
			int i = st.executeUpdate(sql);
			if(i==1){
				admin.commit();
				System.out.println("Updated");
				isUpdated=1;
			}
		}catch(SQLException e){
			try{
				admin.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			System.out.println("Updating was fail...");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,st,rs);
		}
		return isUpdated;
	}

	public static int insertBookImage(InputStream content,String name){
		Connection admin=null;
		int isRegisted=0;
		String sql = "insert into bookimage values(?,?)";
		System.out.println(sql);
		try{
			admin = connectAsAdmin();
			admin.setAutoCommit(false);
			pstmt = admin.prepareStatement(sql);
			pstmt.setBlob(1,content);
			pstmt.setString(2,name);

			isRegisted=pstmt.executeUpdate();
			admin.commit();
		}catch(SQLException e){
			try{
				admin.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			System.out.println("Fail....");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,pstmt,rs);
		}
		return isRegisted;
	}

	public static byte[] findBookImage(String name){
		Connection admin = null;
		String sql = "select content from bookimage where name = ?";
		byte[] content= new byte[3000*4000];
		try{
			admin=connectAsAdmin();
			pstmt=admin.prepareStatement(sql);
			pstmt.setString(1,name);

			rs = pstmt.executeQuery();
			if(rs.next()){
				content = rs.getBytes("content");
			}
		}catch(SQLException e){
			try{
				admin.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			System.out.println("SQLException.");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,pstmt,rs);
		}
		return content;
	}

}
