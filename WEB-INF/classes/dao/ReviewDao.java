package dao;

import java.util.List;
import bean.EbReviewBean;

//ebreview‚É‘Î‚·‚éSQL
public interface ReviewDao{
   public void addReview(EbReviewBean er);
   // public EbReviewBean getReview(String key);
   public List getBookReview(String book_isbn);
   public void updateReview(EbReviewBean er);
   public void deleteReview(EbReviewBean er);
}