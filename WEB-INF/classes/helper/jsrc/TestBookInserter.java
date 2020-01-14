package helper.jsrc;
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
import helper.IsbnDataGetter;
import java.text.SimpleDateFormat;
public class TestBookInserter{
    //isbn入力したら本のデータDBにinsertするやつ
    public static void main(String[] args){
        //isbnをargsから受け取る
        String isbn=args[0];
        //isbn使ってデータbeanに突っ込む
        EbBookBean bbb=new EbBookBean();
        bbb.setBook_isbn(isbn);
        bbb.setBook_amount(1);
        bbb.setBook_price(100);
        bbb.setGenre_id(1);
        IsbnDataGetter.getIsbnData(bbb);
        //dbに接続,sql作る,preparedstatement,バインド変数に代入,executeUpdate,切断
        registBook(bbb);
        
    }
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
    public static int registBook(EbBookBean bbb){

        Connection admin=null;
        PreparedStatement pstmt=null;
		int isRegisted=0;
		String sql = "insert into EBBOOK(book_amount,book_price,genre_id,book_isbn,book_name,publisher,series,volume,author,release_date,audience,label,text_content) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		try{
			admin = connectAsAdmin();
			admin.setAutoCommit(false);
			pstmt = admin.prepareStatement(sql);
			pstmt.setInt(1,bbb.getBook_amount());
			pstmt.setInt(2,bbb.getBook_price());
			pstmt.setInt(3,bbb.getGenre_id());
			pstmt.setString(4,bbb.getBook_isbn());
			pstmt.setString(5,bbb.getBook_name());
            pstmt.setString(6,bbb.getPublisher());
            pstmt.setString(7,bbb.getSeries());
            pstmt.setInt(8,bbb.getVolume());
            pstmt.setString(9,bbb.getAuthor());

            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
            java.util.Date date=sdf.parse(bbb.getRelease_date());
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            pstmt.setDate(10,sqldate);

            pstmt.setString(11,bbb.getAudience());
            pstmt.setString(12,bbb.getLabel());
            pstmt.setString(13,bbb.getText_content());

			isRegisted=pstmt.executeUpdate();
			admin.commit();
		// }catch(SQLException e){
		// 	try{
		// 		admin.rollback();
		// 	}catch(SQLException ex){
		// 		ex.printStackTrace();
		// 	}
		// 	System.out.println("This book has already exited!");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect(admin,pstmt,null);
		}
		return isRegisted;
	}
}