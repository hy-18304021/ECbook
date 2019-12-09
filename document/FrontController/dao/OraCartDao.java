package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbCartBean;

//ebcart‚É‘Î‚·‚éSQL
public class OraCartDao implements CartDao{
   public void addCart(EbCartBean ec){}
   public EbCartBean getCart(String key){}
   public List getAllCart(){}
   public void upDateCart(EbCartBean ec){}
   public void deleteCart(EbCartBean ec){}
}