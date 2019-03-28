<%@ page import="java.time.LocalDateTime" %>
<html>
    <body>
        <h2>Hello World!</h2>

        <form action="/serv" method="post">
            Name: <input type="text" name="param1" value="Zelensky"/> <br/>
            Age: <input type="text" name="param2" value="43"/> <br/>
            <input type="submit" value="send"/>
        </form>
        <%-- JSP comment --%>

        <%= request %>

        <%!
            private int count;
        %>
        <p/>
        <%= count++ %>

        <p/>
        <%
            LocalDateTime date = LocalDateTime.now();
            out.println(date);
        %>

        <a href="/anketa.jsp">Home work1</a>
    </body>
</html>
