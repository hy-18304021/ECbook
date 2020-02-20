package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import bean.EbBookBean;

//ebbookに対するSQL
public class OraBookDao implements BookDao{
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs = null;
    public void addBook(EbBookBean eb){
        // Connection cn=null;

        try{
            //SQL文生成
            String sql = "insert into EBBOOK(book_amount,book_price,genre_id,book_isbn,book_name,publisher,series,volume,author,release_date,audience,label,text_content) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //stのインスタンス取得
            st=OracleConnect.getInstance().getConnection().prepareStatement(sql);

            //バインド変数の設定
            st.setInt(1,eb.getBook_amount());
            st.setInt(2,eb.getBook_price());
            st.setInt(3,eb.getGenre_id());
            st.setString(4,eb.getBook_isbn());
            st.setString(5,eb.getBook_name());
            st.setString(6,eb.getPublisher());
            st.setString(7,eb.getSeries());
            st.setInt(8,eb.getVolume());
            st.setString(9,eb.getAuthor());

            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
            java.util.Date date=sdf.parse(eb.getRelease_date());
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            st.setDate(10,sqldate);
            
            st.setString(11,eb.getAudience());
            st.setString(12,eb.getLabel());
            st.setString(13,eb.getText_content());

            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            //ロールバック処理
            OracleConnect.getInstance().rollback();
        }catch(ParseException e){
            e.printStackTrace();
            OracleConnect.getInstance().rollback();
		}finally{
            //リソース解放
            try{
                if(st!=null){
                    st.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public EbBookBean getBook(String isbn){
        // PreparedStatement st=null;
        // ResultSet rs=null;
        EbBookBean eb=new EbBookBean();

        try{
            //SQL文生成
            if(cn==null){
                cn = OracleConnect.getInstance().getConnection();
            }
            String sql= "select * from ebbook b JOIN ebgenre g ON g.genre_id=b.genre_id where book_isbn = ?";

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            st.setString(1,isbn);

            rs=st.executeQuery();
            while(rs.next()){
                eb.setBook_amount(rs.getInt("book_amount"));
                eb.setBook_price(rs.getInt("book_price"));
                eb.setGenre_id(rs.getInt("genre_id"));
                eb.setBook_isbn(rs.getString("book_isbn"));
                eb.setBook_name(rs.getString("book_name"));
                eb.setPublisher(rs.getString("publisher"));
                eb.setSeries(rs.getString("series"));
                eb.setVolume(rs.getInt("volume"));
                eb.setAuthor(rs.getString("author"));
                eb.setRelease_date(rs.getString("release_date"));
                eb.setAudience(rs.getString("audience"));
                eb.setLabel(rs.getString("label"));
                eb.setText_content(rs.getString("text_content"));
                eb.setGenre_name("genre_name");
            }
        }catch(SQLException e){
            //ロールバック処理
            OracleConnect.getInstance().rollback();
            e.printStackTrace();
        }finally{
            //リソース解放
            try{
                if(rs!=null){
                    rs.close();
                }
                if(st!=null){
                    st.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return eb;
    }
    public List getAllBook(){
        ArrayList booklist=new ArrayList();
        try{
            if(cn==null){
                cn = OracleConnect.getInstance().getConnection();
            }
            String sql="SELECT * FROM ebbook b JOIN ebgenre g ON g.genre_id=b.genre_id";
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                EbBookBean eb=new EbBookBean();

                eb.setBook_amount(rs.getInt("book_amount"));
                eb.setBook_price(rs.getInt("book_price"));
                eb.setGenre_id(rs.getInt("genre_id"));
                eb.setBook_isbn(rs.getString("book_isbn"));
                eb.setBook_name(rs.getString("book_name"));
                eb.setPublisher(rs.getString("publisher"));
                eb.setSeries(rs.getString("series"));
                eb.setVolume(rs.getInt("volume"));
                eb.setAuthor(rs.getString("author"));
                eb.setRelease_date(rs.getString("release_date"));
                eb.setAudience(rs.getString("audience"));
                eb.setLabel(rs.getString("label"));
                eb.setText_content(rs.getString("text_content"));
                eb.setGenre_name(rs.getString("genre_name"));

                booklist.add(eb);
            }
        }catch(SQLException e){
            //ロールバック処理
            OracleConnect.getInstance().rollback();
        }finally{
            //リソース解放
            try{
                if(rs!=null){
                    rs.close();
                }
                if(st!=null){
                    st.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return booklist;
    }
    public void upDateBook(EbBookBean eb){

        try{

            //SQL文生成
            String sql="update ebbook set book_amount=?,book_price=?,genre_id=?,book_isbn=?,book_name=?,publisher=?,series=?,volume=?,author=?,release_date=?,audience=?,label=?,text_content=? where book_isbn=?";

            st=cn.prepareStatement(sql);

            st.setInt(1,eb.getBook_amount());
            st.setInt(2,eb.getBook_price());
            st.setInt(3,eb.getGenre_id());
            st.setString(4,eb.getBook_isbn());
            st.setString(5,eb.getBook_name());
            st.setString(6,eb.getPublisher());
            st.setString(7,eb.getSeries());
            st.setInt(8,eb.getVolume());
            st.setString(9,eb.getAuthor());

            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
            java.util.Date date=sdf.parse(eb.getRelease_date());
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            st.setDate(10,sqldate);
            st.setString(11,eb.getAudience());
            st.setString(12,eb.getLabel());
            st.setString(13,eb.getText_content());

            st.setString(14,eb.getBook_isbn());

            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            //ロールバック処理
            OracleConnect.getInstance().rollback();
        }catch(ParseException e){
            e.printStackTrace();
            OracleConnect.getInstance().rollback();
        }finally{
            //リソース解放
            try{
                if(st!=null){
                    st.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void deleteBook(EbBookBean eb){

        try{
            if(cn==null){
                cn = OracleConnect.getInstance().getConnection();
            }

            //SQL文生成
            String sql= "delete from ebbook where book_isbn=?";

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            st.setString(1,eb.getBook_isbn());

            st.executeUpdate();
        }catch(SQLException e){
            //ロールバック処理
            OracleConnect.getInstance().rollback();
        }finally{
            //リソース解放
            try{
                if(st!=null){
                    st.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public List getRecommendedBooks(){
        ArrayList recommendedBooks =new ArrayList();
        try{
            if(cn==null){
                cn = OracleConnect.getInstance().getConnection();
            }

            String sql= "SELECT b.*,(SELECT sum(r.review_star)/count(0)FROM ebreview r WHERE r.book_isbn=b.book_isbn GROUP BY b.book_isbn) star,(SELECT g.genre_name FROM ebgenre g WHERE g.genre_id=b.genre_id ) genre_name FROM ebbook b ORDER BY star DESC NULLS LAST FETCH FIRST 4 ROWS ONLY";

            st=cn.prepareStatement(sql);
            rs=st.executeQuery();
            while(rs.next()){
                EbBookBean bookbean = new EbBookBean();

                bookbean.setBook_amount(rs.getInt("book_amount"));
                bookbean.setBook_price(rs.getInt("book_price"));
                bookbean.setGenre_id(rs.getInt("genre_id"));
                bookbean.setBook_isbn(rs.getString("book_isbn"));
                bookbean.setBook_name(rs.getString("book_name"));
                bookbean.setPublisher(rs.getString("publisher"));
                bookbean.setSeries(rs.getString("series"));
                bookbean.setVolume(rs.getInt("volume"));
                bookbean.setAuthor(rs.getString("author"));
                bookbean.setRelease_date(rs.getString("release_date"));
                bookbean.setAudience(rs.getString("audience"));
                bookbean.setLabel(rs.getString("label"));
                bookbean.setText_content(rs.getString("text_content"));
                bookbean.setGenre_name(rs.getString("genre_name"));

                bookbean.setBook_star(rs.getInt("star"));

                recommendedBooks.add(bookbean);
            }
        }catch(SQLException e){
            //ロールバック処理
            OracleConnect.getInstance().rollback();
        }finally{
            //リソース解放
            try{
                if(st!=null){
                    st.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return recommendedBooks;
    }

    public List getRecommendedBooks(int genre_id){
        ArrayList recommendedBooks =new ArrayList();
        try{
            if(cn==null){
                cn = OracleConnect.getInstance().getConnection();
            }

            String sql= "SELECT b.*,(SELECT sum(r.review_star)/count(0)FROM ebreview r WHERE r.book_isbn=b.book_isbn GROUP BY b.book_isbn) star,(SELECT g.genre_name FROM ebgenre g WHERE g.genre_id=b.genre_id ) genre_name FROM ebbook b WHERE b.genre_id = ? ORDER BY star DESC NULLS LAST FETCH FIRST 4 ROWS ONLY";

            st=cn.prepareStatement(sql);
            st.setInt(1,genre_id);
            rs=st.executeQuery();
            while(rs.next()){
                EbBookBean bookbean = new EbBookBean();

                bookbean.setBook_amount(rs.getInt("book_amount"));
                bookbean.setBook_price(rs.getInt("book_price"));
                bookbean.setGenre_id(rs.getInt("genre_id"));
                bookbean.setBook_isbn(rs.getString("book_isbn"));
                bookbean.setBook_name(rs.getString("book_name"));
                bookbean.setPublisher(rs.getString("publisher"));
                bookbean.setSeries(rs.getString("series"));
                bookbean.setVolume(rs.getInt("volume"));
                bookbean.setAuthor(rs.getString("author"));
                bookbean.setRelease_date(rs.getString("release_date"));
                bookbean.setAudience(rs.getString("audience"));
                bookbean.setLabel(rs.getString("label"));
                bookbean.setText_content(rs.getString("text_content"));
                bookbean.setGenre_name(rs.getString("genre_name"));

                bookbean.setBook_star(rs.getInt("star"));

                recommendedBooks.add(bookbean);
            }
        }catch(SQLException e){
            //ロールバック処理
            OracleConnect.getInstance().rollback();
        }finally{
            //リソース解放
            try{
                if(st!=null){
                    st.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return recommendedBooks;
    }

    public List searchBook(EbBookBean eb){
        ArrayList searchedBooks =new ArrayList();
        // System.out.println("searchBook");
        try{
            if(cn==null){
                cn = OracleConnect.getInstance().getConnection();
            }

            String sql= "";
            // System.out.println(eb.getGenre_id());
            if(eb.getGenre_id()!=0){
                if(eb.getBook_name()!=null){
                    sql = "SELECT * from ebbook b JOIN ebgenre g ON g.genre_id=b.genre_id WHERE UPPER(b.book_name) like ? AND b.genre_id = ?";
                    st=cn.prepareStatement(sql);
                    st.setString(1,"%"+eb.getBook_name().toUpperCase()+"%");
                    st.setInt(2,eb.getGenre_id());
                }else{
                    sql = "SELECT * from ebbook b JOIN ebgenre g ON g.genre_id=b.genre_id WHERE b.genre_id = ?";
                    st=cn.prepareStatement(sql);
                    st.setInt(1,eb.getGenre_id());
                }
            }else if(eb.getGenre_id()==0){
                if(eb.getBook_name()!=null){
                    sql = "SELECT * FROM ebbook b JOIN ebgenre g ON g.genre_id=b.genre_id WHERE UPPER(b.book_name) like ?";
                    st=cn.prepareStatement(sql);
                    st.setString(1,"%"+eb.getBook_name().toUpperCase()+"%");
                }else{
                    System.out.println("No genre and no name. No search.");
                }
            }

            rs=st.executeQuery();
            while(rs.next()){
                EbBookBean bookbean = new EbBookBean();

                bookbean.setBook_amount(rs.getInt("book_amount"));
                bookbean.setBook_price(rs.getInt("book_price"));
                bookbean.setGenre_id(rs.getInt("genre_id"));
                bookbean.setBook_isbn(rs.getString("book_isbn"));
                bookbean.setBook_name(rs.getString("book_name"));
                bookbean.setPublisher(rs.getString("publisher"));
                bookbean.setSeries(rs.getString("series"));
                bookbean.setVolume(rs.getInt("volume"));
                bookbean.setAuthor(rs.getString("author"));
                bookbean.setRelease_date(rs.getString("release_date"));
                bookbean.setAudience(rs.getString("audience"));
                bookbean.setLabel(rs.getString("label"));
                bookbean.setText_content(rs.getString("text_content"));
                bookbean.setGenre_name(rs.getString("genre_name"));


                searchedBooks.add(bookbean);
            }
        }catch(SQLException e){
            //ロールバック処理
            OracleConnect.getInstance().rollback();
            e.printStackTrace();
        }finally{
            //リソース解放
            try{
                if(st!=null){
                    st.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return searchedBooks;

    }

}