package ua.kiev.prog;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/question")
public class QuestionServlet extends HttpServlet {

    static final int question1Yes = 0;
    static final int question1No = 1;
    static final int question2Yes = 2;
    static final int question2No = 3;

    static  final String temp = "<html>" +
            "<head><title>Anketa</title></head>" +
            "<body><h2> %s </h2></body></html>";

    final int[] results = new int[4];

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    final  String q1 = req.getParameter("question1");
        final  String q2 = req.getParameter("question2");

        final  int idx1 = "yes".equals(q1) ? question1Yes : question1No;
        final  int idx2 = "yes".equals(q2) ? question2Yes : question2No;

        results[idx1]++;
        results[idx2]++;

        String result = "<p>Question 1: yes = " + results[question1Yes] +
                ", no = " + results[question1No] + "</p>";
        result+= "<p>Question 2: yes = " + results[question2Yes] +
                ", no = " + results[question2No] + "</p>";
        resp.getWriter().println(String.format(temp, result));
    }
}
