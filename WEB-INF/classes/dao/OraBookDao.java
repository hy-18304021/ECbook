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

//ebbook�ɑ΂���SQL
public class OraBookDao implements BookDao{
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs = null;
    public void addBook(EbBookBean eb){
        // Connection cn=null;

        try{
            //SQL������
            String sql = "insert into EBBOOK(book_amount,book_price,genre_id,book_isbn,book_name,publisher,series,volume,author,release_date,audience,label,text_content) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //st�̃C���X�^���X�擾
            st=OracleConnect.getInstance().getConnection().prepareStatement(sql);

            //�o�C���h�ϐ��̐ݒ�
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
            //���[���o�b�N����
            OracleConnect.getInstance().rollback();
        }catch(ParseException e){
            e.printStackTrace();
            OracleConnect.getInstance().rollback();
		}finally{
            //���\�[�X���
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
            //SQL������
            if(cn==null){
                cn = OracleConnect.getInstance().getConnection();
            }
            String sql= "select * from ebbook where book_isbn = ?";

            //st�̃C���X�^���X�擾
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
            }
        }catch(SQLException e){
            //���[���o�b�N����
            OracleConnect.getInstance().rollback();
        }finally{
            //���\�[�X���
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
                eb.setRelease_date(rs.getString("release_date"));
                eb.setAudience(rs.getString("audience"));
                eb.setLabel(rs.getString("label"));
                eb.setText_content(rs.getString("text_content"));

                booklist.add(eb);
            }
        }catch(SQLException e){
            //���[���o�b�N����
            OracleConnect.getInstance().rollback();
        }finally{
            //���\�[�X���
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

            //SQL������
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
            //���[���o�b�N����
            OracleConnect.getInstance().rollback();
        }catch(ParseException e){
            e.printStackTrace();
            OracleConnect.getInstance().rollback();
        }finally{
            //���\�[�X���
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

            //SQL������
            String sql= "delete from ebubook where book_isbn=?";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);

            st.setString(1,eb.getBook_isbn());

            st.executeUpdate();
        }catch(SQLException e){
            //���[���o�b�N����
            OracleConnect.getInstance().rollback();
        }finally{
            //���\�[�X���
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

            String sql= "SELECT b.book_isbn, b.book_name, b.book_price, sum(r.review_star)/count(0) star FROM ebbook b INNER JOIN ebreview r ON b.book_isbn = r.book_isbn GROUP BY b.book_isbn, b.book_name, b.book_price ORDER BY star DESC FETCH FIRST 5 ROWS ONLY";

            st=cn.prepareStatement(sql);
            rs=st.executeQuery();
            while(rs.next()){
                EbBookBean bookbean = new EbBookBean();
                bookbean.setBook_isbn(rs.getString("book_isbn"));
                bookbean.setBook_name(rs.getString("book_name"));
                bookbean.setBook_price(rs.getInt("book_price"));
                bookbean.setBook_star(rs.getInt("star"));

                recommendedBooks.add(bookbean);
            }
        }catch(SQLException e){
            //���[���o�b�N����
            OracleConnect.getInstance().rollback();
        }finally{
            //���\�[�X���
            try{
                if(st!=null){
                    st.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return recommendedBooks;
    }
}