import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/demo")
public class Demo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
//        String info=request.getParameter("info");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String date = request.getParameter("date");
        String sex = request.getParameter("sex");
        String[] hobbies = request.getParameterValues("hobby");
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head><title>接收表单输入</title></head>");
        out.println("<body>");
        out.println("<h1>"+username+"</h1>");
        out.println("<h1>"+password+"</h1>");
        out.println("<h1>"+date+"</h1>");
        out.println("<h1>"+sex+"</h1>");
        for (String hobby : hobbies) {
            out.println("<h1>"+hobby+"</h1>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
