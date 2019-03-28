package ua.kiev.prog;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/serv")
public class serv extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String param1 = req.getParameter("param1");
        String param2 = req.getParameter("param2");
        resp.setContentType("text/html");
        resp.getWriter().printf("<h2> Hello servlet:%s %s</h2>", param1,param2);
    }
}
