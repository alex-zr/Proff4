package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/serv")
public class Serv extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        processParams(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processParams(req, resp);
    }

    private void processParams(HttpServletRequest req, HttpServletResponse resp) throws IOException { //alt+command+M
        // Работа с сессиями
        //проверка сессии
        HttpSession session = req.getSession(false);
        if(session == null){
            //auth
            session = req.getSession();
    //        session.getAttribute("userId", 2);
        } else {
            Long userId = (Long) session.getAttribute("userId");
        }
        // время работа сессии
        session.setMaxInactiveInterval(10*60); // в секундах

        //удаление сессии
        session.invalidate();

        String param1 = req.getParameter("param1");
        String param2 = req.getParameter("param2");
        resp.setContentType("text/html");
        resp.getWriter().printf("<h2>Hello servlet: %s %s </h2>",
                param1,
                param2);
    }
}

