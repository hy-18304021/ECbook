package dao;

import java.util.List;
import bean.EbSalesBean;

//ebsales‚É‘Î‚·‚éSQL
public interface SalesDao{
   public void addSales(EbSalesBean es);
   public EbSalesBean getSales(String key);
   public List getAllSales();
   public void upDateSales(EbSalesBean es);
   public void deleteSales(EbSalesBean es);
   public List getUserSales(String userid);
}