package helper.jsrc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import bean.EbBookBean;
import bean.EbUserBean;
import helper.IsbnDataGetter;
import java.text.SimpleDateFormat;

public class TestBookLDR{
    //isbn入力したら本のデータDBにinsertするやつ
    public static void main(String[] args){
        // //isbnをargsから受け取る
        // String isbn=args[0];
        

        //isbn.txtからisbnを読み込みそれ使ってEbBookBeanのListを作る
        //isbnのリスト
        ArrayList<String> isbns=new ArrayList<String>();
        ArrayList<EbBookBean> books=new ArrayList<EbBookBean>();
        String filename = "helper/jsrc/isbn.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(new File(filename)))){
            String line;
            while((line = in.readLine()) != null) isbns.add(line);
        } catch (FileNotFoundException e){ 
            e.printStackTrace();
            System.exit(-1); // 0 以外は異常終了
        } catch (IOException e){ 
            e.printStackTrace();
            System.exit(-1);
        }
        for(int i=0;i<isbns.size();i++){
            String isbn=isbns.get(i);
            //isbn使ってデータbeanに突っ込む
            EbBookBean bbb=new EbBookBean();
            bbb.setBook_isbn(isbn);
            bbb.setBook_amount(100);
            bbb.setBook_price(100*(1+i%4));
            bbb.setGenre_id(i%3);
            IsbnDataGetter.getIsbnData(bbb);
            books.add(bbb);
        }
        //ldrファイルに追加する
        registLDR(books);
    }
    public static void registLDR(ArrayList<EbBookBean> books){
        try {
 
            // 出力ファイルの作成
            FileWriter f = new FileWriter("helper/jsrc/EBBOOK_DATA_TABLE.ldr", true);
            PrintWriter p = new PrintWriter(new BufferedWriter(f));
 
 
            // 内容をセットする
            for(int i = 0; i < books.size(); i++){
                p.print(books.get(i).getBook_amount());p.print(",");// book_amount
                p.print(books.get(i).getBook_price());p.print(",");// book_price
                p.print(books.get(i).getGenre_id());p.print(",");// genre_id
                p.print(books.get(i).getBook_isbn());p.print(",");// book_isbn
                p.print(books.get(i).getBook_name());p.print(",");// book_name
                p.print(books.get(i).getPublisher());p.print(",");// publisher
                p.print(books.get(i).getSeries());p.print(",");// series
                p.print(books.get(i).getVolume());p.print(",");// volume
                p.print(books.get(i).getAuthor());p.print(",");// author
                p.print(books.get(i).getRelease_date());p.print(",");// release_date
                p.print(books.get(i).getAudience());p.print(",");// audience
                p.print(books.get(i).getLabel());p.print(",");// label
                p.print(books.get(i).getText_content());p.print(",");// text_content
                p.println();    // 改行
            }
 
            // ファイルに書き出し閉じる
            p.close();
 
            System.out.println("ファイル出力完了！");
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}


