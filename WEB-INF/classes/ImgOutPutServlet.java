import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ImgOutPutServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
        System.out.println("にゃーん");
        String jpg = req.getParameter("jpg");
        jpg="C:/Users/koyama/Documents/ECbook/img/book/"+jpg+".jpg";
        BufferedImage jpgImage = ImageIO.read(new FileInputStream(jpg));
        // 画像をクライアントに返却する
        res.setContentType("image/jpeg");
        OutputStream os = res.getOutputStream();
        ImageIO.write(jpgImage, "jpg", os);
        os.flush();
    }
}