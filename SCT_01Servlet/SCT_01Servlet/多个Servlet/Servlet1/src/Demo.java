import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 获取请求信息并进行转发
 */
@WebServlet("/Demo")
public class Demo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取表单信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String date = request.getParameter("date");
        String sex = request.getParameter("sex");
        String[] hobbies = request.getParameterValues("hobby");
        //请求转发
        request.getSession().setAttribute("message", username + password );
        //将获取到的信息进行转发，由另一个servlet进行页面信息的输出
        request.getRequestDispatcher("/Demo2").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
