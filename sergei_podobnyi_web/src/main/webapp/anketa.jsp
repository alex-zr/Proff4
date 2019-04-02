<%--
  Created by IntelliJ IDEA.
  User: shprot
  Date: 2019-04-02
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Anketa</title>
</head>
    <body>
        <form action="/question" method="POST">

            Name: <input type="text" name="param1" value=""/>
            <br/>
            LastName: <input type="text" name="param2" value=""/>
            <br/>
            Age: <input type="text" name="param3" value=""/>
            <br/>
            Do you like Java?
            <br/><input type="radio" name="question1" value="yes"/> Yes
            <br/><input type="radio" name="question1" value="no"/>  No

            <br/>Do you like .NET?
            <br/><input type="radio" name="question2" value="yes"/> Yes
            <br/><input type="radio" name="question2" value="no"/>  No

            <br/><input type="submit" value="send"/>
        </form>
    </body>
</html>
