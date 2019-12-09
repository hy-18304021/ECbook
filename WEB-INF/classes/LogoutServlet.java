import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

//ログアウト処理
public class LogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{

        HttpSession session=((HttpServletRequest) req).getSession();
        session.removeAttribute("flag");

        //ホームへ
		RequestDispatcher dis=req.getRequestDispatcher("/index");
		dis.forward(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		doGet(req,res);
	}
}