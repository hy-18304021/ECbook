package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbBookBean;

//ebbookに対するSQL
public class OraBookDao implements BookDao{
    public void addBook(EbBookBean eb){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "insert into ebbook values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            //バインド変数の設定
            st.setInt(1,eu.getBook_amount());
            st.setInt(2,eu.getBook_price());
            st.setInt(3,eu.getGenre_id());
            st.setString(4,eu.getBook_isbn());
            st.setString(5,eu.getBook_name());
            st.setString(6,eu.getPublisher());
            st.setString(7,eu.getSeries());
            st.setInt(8,eu.getVolume());
            st.setString(9,eu.getAuthor());
            st.setInt(10,eu.getRelease_date());
            st.setString(11,eu.getAudience());
            st.setString(12,eu.getLabel());
            st.setString(13,eu.getText_content());

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
    public EbBookBean getBook(String key){
        PreparedStatement st=null;
        Connection cn=null;
        ResultSet rs=null;
        EbBookBean eb=new EbBookBean();

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "select * from ebbook where book_isbn = ?";

            st.setString(1,key);

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

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
                eb.setRelease_date(rs.getInt("release_date"));
                eb.setAudience(rs.getString("audience"));
                eb.setLabel(rs.getString("label"));
                eb.setText_content(rs.getString("text_content"));
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
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return eb;
    }
    public List getAllBook(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
    
        ArrayList<EbBookBean> bookdates=new ArrayList<>();
    
        try{
            cn=OracleConnect.getInstance().getConnection();

            String sql="select * from ebbook";
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
                eb.setRelease_date(rs.getInt("release_date"));
                eb.setAudience(rs.getString("audience"));
                eb.setLabel(rs.getString("label"));
                eb.setText_content(rs.getString("text_content"));
    
                bookdates.add(eb);
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
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return bookdates;
    }
    public void upDateBook(EbBookBean eb){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql="update ebbook set book_amount=?,book_amount=?,genre_id=?,book_isbn=?,book_name=?,publisher=?,series=?,volume=?,author=?,release_date=?,audience=?,label=?,text_content=? where book_isbn=?";

            st.setInt(1,eu.getBook_amount());
            st.setInt(2,eu.getBook_price());
            st.setInt(3,eu.getGenre_id());
            st.setString(4,eu.getBook_isbn());
            st.setString(5,eu.getBook_name());
            st.setString(6,eu.getPublisher());
            st.setString(7,eu.getSeries());
            st.setInt(8,eu.getVolume());
            st.setString(9,eu.getAuthor());
            st.setInt(10,eu.getRelease_date());
            st.setString(11,eu.getAudience());
            st.setString(12,eu.getLabel());
            st.setString(13,eu.getText_content());
            st.setString(14,eu.getBook_isbn());

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
    public void deleteBook(EbBookBean eb){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "delete from ebubook where book_isbn=?";

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            st.setString(1,eu.getBook_isbn());

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
}