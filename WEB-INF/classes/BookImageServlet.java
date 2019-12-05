import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import DBOracle.OracleController;
import DBOracle.OracleProfile;


public class BookImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String imageName = req.getPathInfo(); // Returns "/foo.png".
        // byte[] content = OracleController.findBookImage(imageName);
        // response.setContentType(getServletContext().getMimeType(imageName));
        // response.setContentLength(content.length);
        // response.getOutputStream().write(content);
        RequestDispatcher dis=req.getRequestDispatcher("/img/book"+imageName);
        dis.forward(req,res);


    }

}