import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/stats"})
public class MyServlet extends HttpServlet {

    public static final int q1_yes = 0;
    public static final int q1_no = 1;
    public static final int q2_yes = 2;
    public static final int q2_no = 3;
    public static final int q2_sometimes = 4;
    public static final int q3_yes = 5;
    public static final int q3_no = 6;

    public static final String TEMPLATE =
            "<!doctype html><html lang='en'><head><meta charset='UTF-8'>"
                    + "<title>Answers</title></head><body>Statistics:<p/><p/>"
                    + "Having a pet<p/>yes: %s<p/>no: %s<p/><p/>Swimming<p/>yes: %s<p/>no: %s<p/>"
                    + "sometimes: %s<p/><p/>Visiting Hawai<p/>yes: %s<p/>no: %s<p/><p/>"
                    + "<a href='/'>back</a></body></html>";

    public static int[] results;

    @Override
    public void init() throws ServletException {
        super.init();
        results = new int[7];
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String q1 = req.getParameter("q1");
        String q2 = req.getParameter("q2");
        String q3 = req.getParameter("q3");

        if (q1.equals("yes"))
            results[q1_yes]++;
        else if (q1.equals("no"))
            results[q1_no]++;

        if (q2.equals("yes"))
            results[q2_yes]++;
        else if (q2.equals("no"))
            results[q2_no]++;
        else if (q2.equals("sometimes"))
            results[q2_sometimes]++;

        if (q3.equals("yes"))
            results[q3_yes]++;
        else if (q3.equals("no"))
            results[q3_no]++;

        resp.setContentType("text/html");
        resp.getWriter().println(String.format(TEMPLATE,
                results[q1_yes],
                results[q1_no],
                results[q2_yes],
                results[q2_no],
                results[q2_sometimes],
                results[q3_yes],
                results[q3_no]));
    }
}
