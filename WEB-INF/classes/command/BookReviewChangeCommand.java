package command;

import dao.*;
import froc.*;
import bean.*;
import com.google.gson.*;
import java.util.ArrayList;

public class BookReviewChangeCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();

		// System.out.println("BookReviewChangeCommand");

		String method = reqc.getParameter("method")[0];
		String book_isbn = reqc.getParameter("book_isbn")[0];
		String user_id = reqc.getParameter("user_id")[0];
		String review_text = reqc.getParameter("review_text")[0];
		int review_star = Integer.parseInt(reqc.getParameter("review_star")[0]);
		String review_date = reqc.getParameter("review_date")[0];

		review_text = review_text.replace("&", "&amp;");
	    review_text = review_text.replace("\"", "&quot;");
        review_text = review_text.replace("<", "&lt;");
	    review_text = review_text.replace(">", "&gt;");
	    review_text = review_text.replace("'", "&#39;");
	    if (review_text != null) {
	            review_text = review_text.replaceAll("\r\n", "<br>");
	        }

		System.out.println("method:"+method+"\nbook_isbn"+book_isbn+"\nuser_id"+user_id+"\nreview_text:"+review_text);

        EbReviewBean review = new EbReviewBean();
		review.setBook_isbn(book_isbn);
		review.setUser_id(user_id);
		review.setReview_text(review_text);
		review.setReview_star(review_star);
		review.setReview_date(review_date);

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

		resc.setResult(result);

		return resc;
	}
}