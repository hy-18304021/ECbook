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
    //isbn���͂�����{�̃f�[�^DB��insert������
    public static void main(String[] args){
        // //isbn��args����󂯎��
        // String isbn=args[0];
        

        //isbn.txt����isbn��ǂݍ��݂���g����EbBookBean��List�����
        //isbn�̃��X�g
        ArrayList<String> isbns=new ArrayList<String>();
        ArrayList<EbBookBean> books=new ArrayList<EbBookBean>();
        String filename = "helper/jsrc/isbn.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(new File(filename)))){
            String line;
            while((line = in.readLine()) != null) isbns.add(line);
        } catch (FileNotFoundException e){ 
            e.printStackTrace();
            System.exit(-1); // 0 �ȊO�ُ͈�I��
        } catch (IOException e){ 
            e.printStackTrace();
            System.exit(-1);
        }
        for(int i=0;i<isbns.size();i++){
            String isbn=isbns.get(i);
            //isbn�g���ăf�[�^bean�ɓ˂�����
            EbBookBean bbb=new EbBookBean();
            bbb.setBook_isbn(isbn);
            bbb.setBook_amount(100);
            bbb.setBook_price(100*(1+i%4));
            bbb.setGenre_id(i%3);
            IsbnDataGetter.getIsbnData(bbb);
            books.add(bbb);
        }
        //ldr�t�@�C���ɒǉ�����
        registLDR(books);
    }
    public static void registLDR(ArrayList<EbBookBean> books){
        try {
 
            // �o�̓t�@�C���̍쐬
            FileWriter f = new FileWriter("helper/jsrc/EBBOOK_DATA_TABLE.ldr", true);
            PrintWriter p = new PrintWriter(new BufferedWriter(f));
 
 
            // ���e���Z�b�g����
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
                p.println();    // ���s
            }
 
            // �t�@�C���ɏ����o������
            p.close();
 
            System.out.println("�t�@�C���o�͊����I");
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}


