package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import work.crypt.BCrypt;
import work.crypt.SHA256;

public class MngrDBBean {
	
    private static MngrDBBean instance = new MngrDBBean();
    
    //MngrDBBeanリターンする
    public static MngrDBBean getInstance() {
        return instance;
    }
    
    private MngrDBBean() {}
    
    
    private Connection getConnection() throws Exception {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
        return ds.getConnection();
    }
    
    //管理者アカウントが存在するか確認
    public int userCheck(String id, String passwd){
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		int x=-1;
        
		SHA256 sha = SHA256.getInsatnce();
		try {
            conn = getConnection();
            
            String orgPass = passwd;
            String shaPass = sha.getSha256(orgPass.getBytes());
        	
            pstmt = conn.prepareStatement(
              "select managerPasswd from manager where managerId = ?");
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();

			if(rs.next()){//アカウントがあれば実行
				String dbpasswd= rs.getString("managerPasswd"); 
				if(BCrypt.checkpw(shaPass,dbpasswd))
					x= 1; //成功
				else
					x= 0; //パスワードが違う
			}else//アカウントがないとき実行
				x= -1;//アカウントなし
			
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}
    
    //本登録メソッド
    public void insertBook(MngrDataBean book) 
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = getConnection();
            String sql = "insert into book(book_kind,book_title,book_price,";
            sql += "book_count,author,publishing_com,publishing_date,book_image,";
            sql += "book_content,discount_rate,reg_date) values (?,?,?,?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getBook_kind());
            pstmt.setString(2, book.getBook_title());
            pstmt.setInt(3, book.getBook_price());
            pstmt.setShort(4, book.getBook_count());
			pstmt.setString(5, book.getBook_image());
            pstmt.setInt(6,book.getBook_isbn());
			
            pstmt.executeUpdate();
            
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    //登録されている本を確認
	public int registedBookconfirm(
			String kind, String bookName) 
	throws Exception {
		Connection conn = null;
        PreparedStatement pstmt = null;
		ResultSet rs= null;
		int x=-1;
        
		try {
            conn = getConnection();
            
            String sql = "select book_name from book ";
            sql += " where book_kind = ? and book_name = ? ";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kind);
            pstmt.setString(2, bookName);
            
            rs= pstmt.executeQuery();

			if(rs.next())
				x= 1; //本が登録されてある
			else
				x= -1;//本が登録されてない	
			
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
			if (rs != null) 
				try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}
    
	// 登録されてある全体の本の数
	public int getBookCount()
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int x=0;

        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement("select count(*) from book");
            rs = pstmt.executeQuery();

            if (rs.next()) 
               x= rs.getInt(1);
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) 
            	try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
    }
	
	// 特定のジャンルの本の数を確認
	public int getBookCount(String book_kind)
	throws Exception {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    int x=0;
	    int kind  = Integer.parseInt(book_kind);

	    try {
	        conn = getConnection();
	        String query = "select count(*) from book where book_kind=" + kind;
	        pstmt = conn.prepareStatement(query);
	        rs = pstmt.executeQuery();

	        if (rs.next()) 
	            x= rs.getInt(1);
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) 
	           try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) 
	           try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) 
	           try { conn.close(); } catch(SQLException ex) {}
	    }
		return x;
	}
	
	//本の名前を得る
	public String getBookTitle(int book_id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String x="";

        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement("select book_title from book where book_id = "+book_id);
            rs = pstmt.executeQuery();

            if (rs.next()) 
               x= rs.getString(1);
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
        }
		return x;
    }
	//ジャンルまたは全体の本の情報を得る
	public List<MngrDataBean> getBooks(String book_kind)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<MngrDataBean> bookList=null;
        
        try {
            conn = getConnection();
            
            String sql1 = "select * from book";
            String sql2 = "select * from book ";
            sql2 += "where book_kind = ? ";
            
            if(book_kind.equals("all")||book_kind.equals("")){
            	 pstmt = conn.prepareStatement(sql1);
            }else{
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, book_kind);
            }
        	rs = pstmt.executeQuery();
            
            if (rs.next()) {
                bookList = new ArrayList<MngrDataBean>();
                do{
                	MngrDataBean book= new MngrDataBean();
                     
                     book.setBook_id(rs.getInt("book_id"));
                     book.setBook_kind(rs.getString("book_kind"));
                     book.setBook_title(rs.getString("book_title"));
                     book.setBook_price(rs.getInt("book_price"));
                     book.setBook_count(rs.getShort("book_count"));
                     book.setBook_image(rs.getString("book_image"));
                     book.setBook_isbn(rs.getInt("book_isbn"));

                     bookList.add(book);
			    }while(rs.next());
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) 
            	try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return bookList;
    }
	
	// メインに表示するために使うジャンル別新刊目録を得る
	public MngrDataBean[] getBooks(String book_kind,int count)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MngrDataBean bookList[]=null;
        int i=0;
        
        try {
            conn = getConnection();
            
            String sql = "select * from book where book_kind = ? ";
           // sql += "order by reg_date desc limit ?,?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book_kind);
            pstmt.setInt(2, 0);
            pstmt.setInt(3, count);
        	rs = pstmt.executeQuery();

            if (rs.next()) {
                bookList = new MngrDataBean[count];
                do{
                	MngrDataBean book= new MngrDataBean();
                    book.setBook_id(rs.getInt("book_id"));
                    book.setBook_kind(rs.getString("book_kind"));
                    book.setBook_title(rs.getString("book_title"));
                    book.setBook_price(rs.getInt("book_price"));
                    book.setBook_count(rs.getShort("book_count"));
                    book.setBook_image(rs.getString("book_image"));
                    //book.setReg_date(rs.getTimestamp("reg_date"));
                     
                    bookList[i]=book;
                     
                    i++;
			    }while(rs.next());
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) 
            	try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return bookList;
    }
	
	// bookIdに当てはまる情報を得る 
    //登録した本を修正するために読み込むメソッド
	public MngrDataBean getBook(int bookId)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MngrDataBean book=null;
        
        try {
            conn = getConnection();
            
            pstmt = conn.prepareStatement(
            	"select * from book where book_id = ?");
            pstmt.setInt(1, bookId);
            
            rs = pstmt.executeQuery();

            if (rs.next()) {
                book = new MngrDataBean();
                
                book.setBook_kind(rs.getString("book_kind"));
                book.setBook_title(rs.getString("book_title"));
                book.setBook_price(rs.getInt("book_price"));
                book.setBook_count(rs.getShort("book_count"));
                book.setBook_image(rs.getString("book_image"));
                book.setBook_isbn(rs.getInt("book_isbn"));

			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) 
            	try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
		return book;
    }
    
    // 登録されている本の修正
    public void updateBook(MngrDataBean book, int bookId)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql;
        
        try {
            conn = getConnection();
            
            sql = "update book set book_kind=?,book_title=?,book_price=?";
            sql += ",book_count=?";
            sql += ",book_image=?";
            sql += " where book_id=?";
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, book.getBook_kind());
            pstmt.setString(2, book.getBook_title());
            pstmt.setInt(3, book.getBook_price());
            pstmt.setShort(4, book.getBook_count());
			pstmt.setString(5, book.getBook_image());
            pstmt.setInt(6,book.getBook_isbn());
			pstmt.setInt(7, bookId);
            
            pstmt.executeUpdate();
            
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    // bookIdにあてはまる情報を削除
    public void deleteBook(int bookId)
    throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        
        try {
			conn = getConnection();

            pstmt = conn.prepareStatement(
            	"delete from book where book_id=?");
            pstmt.setInt(1, bookId);
            
            pstmt.executeUpdate();
            
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) 
            	try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
    }
}