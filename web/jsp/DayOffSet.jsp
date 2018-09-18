<%@ page import="cn.PApudding.Schedule.MonthGet" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.PApudding.Schedule.SingleDay" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: papudding
  Date: 18-8-20
  Time: 上午1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport" content="width=device-width,minimum-scale=1.0, maximum-scale=2.0" />

<html>
<head>
    <title>工作轮班安排-休息日设定</title>
</head>
<body>
<%!
    MonthGet monthGet;
    List<SingleDay> singleDays;
    Iterator<SingleDay> iterator;
    int i = 0;
    int count = 0;
%>
<%
    count++;
    if(count ==2){
        count = 0;
    }
    session = request.getSession();
    monthGet = (MonthGet) session.getAttribute("MonthGet");
    int year = monthGet.showYearAndMonth()[0];
    int month = monthGet.showYearAndMonth()[1];
    monthGet.calendarGenerate();
    singleDays = monthGet.getSingleDays();
    iterator = singleDays.iterator();
%>
<%=year + "-" + month%>
<form action="DayOffSetServlet" method="post">
    请选择当月的法定节假日和双休日
    <table border="1">
        <tr>
            <td>日</td>
            <td>一</td>
            <td>二</td>
            <td>三</td>
            <td>四</td>
            <td>五</td>
            <td>六</td>
        </tr>

        <% while (iterator.hasNext()) {
            SingleDay currentDay = iterator.next();%>
            <%--缩进控制--%>
            <% if (i % 7 == 0 && i == 0) {%>
                <tr>
                <%  if(currentDay.getDayOfWeek() != 7){
                        for (int j = 0; j < currentDay.getDayOfWeek(); j++) { %>
                            <td>

                            </td>
                        <%  i++;
                        }
                    }
            }
            if (i % 7 == 0) {%>
                </tr><tr>
            <%}%>
            <td>
                <%=currentDay.getDateNum()%>
                <input type="checkbox" name="<%=currentDay.getDateNum()%>"
                       <%if(currentDay.isDayOff){%>checked="checked"<%}%>
                        value="1">
            </td>

            <%i++;
        }%>
        </tr>
        <%i = 0;%>
        <tr><input type="submit" value="确定"></tr>
    </table>
</form>
</body>
</html>
