import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/example")
public class ServletExample extends HttpServlet {
  private String replace;

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws
      IOException, ServletException {

    response.setContentType("text/plain");
    response.getWriter().println("It works!");
  }
}
