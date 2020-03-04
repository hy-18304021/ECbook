package dao;

import java.util.ArrayList;
import java.util.List;
import bean.EbFavoriteBean;

//ebfavorite‚É‘Î‚·‚éSQL
public interface FavoriteDao{
   public void addFavorite(EbFavoriteBean ef);
   public ArrayList getUserFavorite(String user_id);
   public List getAllFavorite();
   public void upDateFavorite(EbFavoriteBean ef);
   public void deleteFavorite(EbFavoriteBean ef);
   public boolean checkFavorite(EbFavoriteBean ef);
}