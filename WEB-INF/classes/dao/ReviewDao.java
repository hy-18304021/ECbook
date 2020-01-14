package dao;

import java.util.List;
import bean.EbReviewBean;

//ebreview‚É‘Î‚·‚éSQL
public interface ReviewDao{
   public void addReview(EbReviewBean er);
   public EbReviewBean getReview(String key);
   public List getAllReview();
   public void upDateReview(EbReviewBean er);
   public void deleteReview(EbReviewBean er);
}