package bean;

import java.io.Serializable;

public class EbGenreBean implements Serializable{
    private int genre_id;
    private String genre_name;

    public EbGenreBean(){}

    public void setGenre_id(int id){
        genre_id=id;
    }

    public void setGenre_name(String name){
        genre_name=name;
    }

    public int getGenre_id(){
        return genre_id;
    }

    public String getGenre_name(){
        return genre_name;
    }

}