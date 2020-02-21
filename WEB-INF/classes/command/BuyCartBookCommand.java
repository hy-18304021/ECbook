package command;

import dao.OracleConnect;
import dao.SalesDao;
import dao.Sales_RefDao;
import dao.BookDao;
import dao.CartDao;
import dao.CreditDao;
import dao.AddressDao;
import dao.AbstractDaoFactory;
import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;
import java.util.ArrayList;
import java.util.List;
import bean.EbCartBean;
import bean.EbCreditBean;
import bean.EbAddressBean;
import bean.EbBookBean;
import bean.EbSalesBean;
import bean.EbSales_RefBean;

//購入するコマンド
public class BuyCartBookCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
        RequestContext reqc = getRequestContext();
        
        //送り先情報
        String btn=reqc.getParameter("btn")[0];
        String user=reqc.getParameter("user_id")[0];
        String name=reqc.getParameter("firstname")[0];
        int address_id=0;
        int postalcode=Integer.parseInt(reqc.getParameter("postalcode")[0]);
        String address=reqc.getParameter("address")[0];
        String tel=reqc.getParameter("tel")[0];
        //カード情報
        //使わない
        String cardname=reqc.getParameter("cardname")[0];
        String cardnumber=reqc.getParameter("cardnumber")[0];
        String expmonth=reqc.getParameter("expmonth")[0];
        String expyear=reqc.getParameter("expyear")[0];
        String cvv=reqc.getParameter("cvv")[0];

        String expiration=expmonth+"/"+expyear;

        System.out.println(btn);

        EbAddressBean ea=new EbAddressBean();
        ea.setAddress(address);
        ea.setPostal_code(postalcode);
        ea.setTel(tel);
        ea.setUser_id(user);
        ea.setReceiver_name(name);
        
        EbSales_RefBean esr=new EbSales_RefBean();

        EbCartBean ec=new EbCartBean();
        
        EbSalesBean es=new EbSalesBean();
        es.setUser_id(user);

        EbCreditBean ecd=new EbCreditBean();
        ecd.setUser_id(user);
        ecd.setCard_name(cardname);
        ecd.setCard_number(cardnumber);
        ecd.setSecurity_number(cvv);
        ecd.setCard_expiration(expiration);

        EbBookBean eb=new EbBookBean();
        
        AbstractDaoFactory daofac=AbstractDaoFactory.getFactory(reqc);
        CartDao cartdao=daofac.getCartDao();
        CreditDao creditDao=daofac.getCreditDao();
        AddressDao addressdao=daofac.getAddressDao();
	BookDao bookdao=daofac.getBookDao();
	SalesDao salesdao=daofac.getSalesDao();
        Sales_RefDao sales_refdao=daofac.getSales_RefDao();
        
        OracleConnect.getInstance().beginTransaction();

        if(btn.equals("0")){
                System.out.println("s");
                addressdao.addAddress(ea);
                ea=addressdao.getLastAddress_id();
                es.setAddress_id(ea.getAddress_id());
        }else{
                address_id=Integer.parseInt(reqc.getParameter("address_id")[0]);
                es.setAddress_id(address_id);
        }

        //カート情報取得
        ArrayList<EbCartBean> mycart = cartdao.getUserCartInfo(user);
        System.out.println(mycart.get(0).getBook_isbn());
        //カード情報をDBに入れる
        creditDao.addCredit(ecd);
        
        System.out.println(es.getAddress_id());
        System.out.println("mycartSize:"+mycart.size());

        salesdao.addSales(es);
        
        
        for(int i=0;i<mycart.size();i++){
                System.out.println("sa");
                ec=mycart.get(i);
                System.out.println("s");
                eb=bookdao.getBook(ec.getBook_isbn());
                esr.setBook_isbn(ec.getBook_isbn());
                esr.setSales_amount(ec.getCart_amount());
                sales_refdao.addSales_Ref(esr);
                System.out.println(eb.getBook_amount() - ec.getCart_amount());
                eb.setBook_amount(eb.getBook_amount()-ec.getCart_amount());
                bookdao.upDateBook(eb);
                System.out.println("かか");
                cartdao.deleteBook(ec);
        }


        
        OracleConnect.getInstance().commit();
        OracleConnect.getInstance().closeConnection();

        resc.setTarget("mypage");
        return resc;
	}
}