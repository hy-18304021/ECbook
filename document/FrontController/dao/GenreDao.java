package dao;

import java.util.List;
import bean.EbGenreBean;

//ebgenre�ɑ΂���SQL
public interface GenreDao{
   public void addGenre(EbGenreBean eg);
   public EbGenreBean getGenre(String key);
   public List getAllGenre();
   public void upDateGenre(EbGenreBean eg);
   public void deleteGenre(EbGenreBean eg);
}