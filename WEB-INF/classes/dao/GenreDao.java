package dao;

import java.util.List;
import bean.EbGenreBean;

//ebgenre‚É‘Î‚·‚éSQL
public interface GenreDao{
   public void addGenre(EbGenreBean eg);
   public EbGenreBean getGenre(String key);
   public List getAllGenre();
   public void upDateGenre(EbGenreBean eg);
   public void deleteGenre(EbGenreBean eg);
}