package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbGenreBean;

//ebgenreに対するSQL
public class OraGenreDao implements GenreDao{
    public void addGenre(EbGenreBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "insert into ebgenre values(?,?)";

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            //バインド変数の設定
            st.setInt(1,ec.getGenre_id());
            st.setString(2,ec.getGenre_name());

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
    public EbGenreBean getGenre(String key){
        PreparedStatement st=null;
        Connection cn=null;
        ResultSet rs=null;
        EbGenreBean eb=new EbGenreBean();

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "select * from ebgenre where genre_id = ?";

            st.setInt(1,Integer.parseInt(key));

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                eb.setGenre_id(rs.getInt("genre_id"));
                eb.setGenre_name(rs.getString("genre_name"));
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
    public List getAllGenre(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList<EbGenreBean> genredates=new ArrayList<>();

        try{
            cn=OracleConnect.getInstance().getConnection();

            String sql="select * from ebcresit";
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                EbGenreBean eb=new EbGenreBean();

                eb.setGenre_id(rs.getInt("genre_id"));
                eb.setGenre_name(rs.getString("genre_name"));

                genredates.add(eb);
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
        return genredates;
    }
    public void upDateGenre(EbGenreBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql="update ebgenre set genre_id=?,genre_name where genre_id=?";

            st.setInt(1,ec.getGenre_id());
            st.setString(2,ec.getGenre_name());
            st.setInt(3,ec.getGenre_id());

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
    public void deleteGenre(EbGenreBean ec){}
}