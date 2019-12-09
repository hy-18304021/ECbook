package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbBookBean;

//ebbook‚É‘Î‚·‚éSQL
public class OraBookDao implements BookDao{
    public void addBook(EbBookBean eb){}
    public EbBookBean getBook(String key){}
    public List getAllBook(){}
    public void upDateBook(EbBookBean eb){}
    public void deleteBook(EbBookBean eb){}
}