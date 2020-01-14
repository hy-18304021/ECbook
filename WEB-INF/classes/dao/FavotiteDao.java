package dao;

import java.util.List;
import bean.EbFavotiteBean;

//ebfavotite‚É‘Î‚·‚éSQL
public interface FavotiteDao{
   public void addFavotite(EbFavotiteBean ef);
   public EbFavotiteBean getFavotite(String key);
   public List getAllFavotite();
   public void upDateFavotite(EbFavotiteBean ef);
   public void deleteFavotite(EbFavotiteBean ef);
}