package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/serv")
public class Serv extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        processParams(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processParams(req, resp);
    }

    private void processParams(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String param1 = req.getParameter("param1");
        String param2 = req.getParameter("param2");
        resp.setContentType("text/html");
        resp.getWriter().printf("<h2>Hello servlet: %s %s </h2>",
                param1,
                param2);
    }
}
