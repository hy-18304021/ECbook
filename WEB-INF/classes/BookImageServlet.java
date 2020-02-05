import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;


public class BookImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String imageName = req.getPathInfo();
        // System.out.println("/WEB-INF/img/book"+imageName);
<<<<<<< HEAD
        RequestDispatcher dis=req.getRequestDispatcher("/WEB-INF/img/book"+imageName+".png");
=======
        RequestDispatcher dis=req.getRequestDispatcher("/WEB-INF/img/book/"+imageName+".jpg");
>>>>>>> 83a727ad211c3b20f304a8439c9e54d12b5ba550

        dis.forward(req,res);


    }

}