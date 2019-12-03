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

    // table bookimage: content=blob, name=varchar(255) UNIQUE.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imageName = request.getPathInfo().substring(1); // Returns "foo.png".
        byte[] content = OracleController.findBookImage(imageName);
        response.setContentType(getServletContext().getMimeType(imageName));
        response.setContentLength(content.length);
        response.getOutputStream().write(content);
    }

}