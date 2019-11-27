
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import DBOracle.InsertOracle;
import bean.SelectOracleBean;

public class InsertServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
        req.setCharacterEncoding("Windows-31J");

		int book_id=Integer.parseInt(req.getParameter("book_id"));//本ID
        int book_price=Integer.parseInt(req.getParameter("book_price"));//本値段
        int book_count=Integer.parseInt(req.getParameter("book_count"));//本在庫
        String book_image=req.getParameter("book_image");//本画像
        String book_isbn=req.getParameter("book_isbn");//ISBNコード     
        
        InsertOracle.insertBook(book_id, book_price, book_count, book_image, book_isbn);
        

		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/manager");
		
		//パラメータをJSPに転送
		dis.forward(req,res);
		
    }
}