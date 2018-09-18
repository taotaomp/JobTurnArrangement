<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: papudding
  Date: 18-8-20
  Time: 上午12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport" content="width=device-width,minimum-scale=1.0, maximum-scale=2.0" />
<html>
<head>
    <title>工作轮班安排-年月设定</title>
</head>
<body>
<form action="MonthGet" method="post">
    <table border="0">
        <tr align="center">
            请设定年月
        </tr>
        <tr>
            <td>
                <input type="month" name="yearAndMonth">
            </td>
            <td>
                <input type="submit" value="确定">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
