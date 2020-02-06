import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
// import java.util.List;
import dao.*;
import froc.*;
import bean.*;
import com.google.gson.*;
public class BookReviewChangeServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		String method = req.getParameter("method");
		String book_isbn=req.getParameter("book_isbn");
		String user_id=(String)req.getParameter("user_id");
		String review_text=(String)req.getParameter("review_text");
		System.out.println(req.getParameter("review_star"));
		int review_star= Integer.parseInt(req.getParameter("review_star"));
		String review_date = req.getParameter("review_date");


		System.out.println(method);
		review_text = review_text.replace("&", "&amp;");
        review_text = review_text.replace("\"", "&quot;");
        review_text = review_text.replace("<", "&lt;");
        review_text = review_text.replace(">", "&gt;");
        review_text = review_text.replace("'", "&#39;");

        if (review_text != null) {
            review_text = review_text.replaceAll("\r\n", "<br>");
        }
        EbReviewBean review = new EbReviewBean();
		review.setBook_isbn(book_isbn);
		review.setUser_id(user_id);
		review.setReview_text(review_text);
		review.setReview_star(review_star);
		review.setReview_date(review_date);

		RequestContext reqc = new WebRequestContext();
		reqc.setRequest(req);
		AbstractDaoFactory daofac =AbstractDaoFactory.getFactory(reqc);
		ReviewDao reviewdao = daofac.getReviewDao();

		OracleConnect.getInstance().beginTransaction();

		if(method.contains("add")){
			System.out.println("add");
			reviewdao.addReview(review);
		}
		if(method.contains("update")){
			System.out.println("update");
			reviewdao.updateReview(review);
		}
		if(method.contains("delete")){
			System.out.println("delete");
			reviewdao.deleteReview(review);
		}

		OracleConnect.getInstance().commit();
		// OracleConnect.getInstance().closeConnection();

		ArrayList bookreviewlist = (ArrayList)reviewdao.getBookReview(book_isbn);

		String result = "<h1>REVIEW</h1><table border='1'><thead><tr><th>Name</th><th>Text</th><th>Star</th><th>Date</th><th></th></tr></thead><tbody>";
		for(int i = 0; i<bookreviewlist.size();i++){
			EbReviewBean rb = (EbReviewBean)bookreviewlist.get(i);
			String id = rb.getUser_id();
			String text = rb.getReview_text();
			int star = rb.getReview_star();
			String date = rb.getReview_date();
			result += "<tr><td>"+id+"</td><td>"+text+"<br></td><td>"+star+"</td><td>"+date+"</td><td</td></tr>";
		}
		result += "</tbody></table>";
		// Gson gson = new Gson();
		// String result = gson.toJson(bookreviewlist);
		// System.out.println(result);

		res.setContentType("text/html; charset=UTF-8");
		res.getWriter().write(result);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException,ServletException {
		doPost(req, res);
	}
}