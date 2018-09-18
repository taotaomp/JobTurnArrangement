<%@ page import="cn.PApudding.People.SingleClass" %><%--
  Created by IntelliJ IDEA.
  User: papudding
  Date: 18-8-20
  Time: 下午5:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="viewport" content="width=device-width,minimum-scale=1.0, maximum-scale=2.0" />
<html>
<head>
    <title>工作轮班安排-轮班人设定</title>
</head>
<body>
    <%
        SingleClass[] sClasses = new SingleClass[2];
        sClasses[0] = new SingleClass("胡成元", "俞建强", "1");
        sClasses[1] = new SingleClass("朱光明", "欧月奎", "2");

        session = request.getSession();
        session.setAttribute("sClasses",sClasses);
    %>
<form action="PeopleSetServlet" method="post">
    <table border="1">
        <tr>
            <td colspan="2">
                请选择上个月<b>倒数第二天</b>上班的人
            </td>
        </tr>
        <tr>
            <td>
                白天：
                <select name="lastSecondDayMorning1">
                    <option value="<%=sClasses[0].getSinglePerson(0).getName()%>">
                        <%=sClasses[0].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[0].getSinglePerson(1).getName()%>">
                        <%=sClasses[0].getSinglePerson(1).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(0).getName()%>">
                        <%=sClasses[1].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(1).getName()%>">
                        <%=sClasses[1].getSinglePerson(1).getName()%>
                    </option>
                </select>
                <select name="lastSecondDayMorning2">
                    <option value="无">
                        无
                    </option>
                    <option value="<%=sClasses[0].getSinglePerson(0).getName()%>">
                        <%=sClasses[0].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[0].getSinglePerson(1).getName()%>">
                        <%=sClasses[0].getSinglePerson(1).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(0).getName()%>">
                        <%=sClasses[1].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(1).getName()%>">
                        <%=sClasses[1].getSinglePerson(1).getName()%>
                    </option>
                </select>
            </td>
            <td>
                晚上：
                <select name="lastSecondDayNight">
                    <option value="<%=sClasses[0].getSinglePerson(0).getName()%>">
                        <%=sClasses[0].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[0].getSinglePerson(1).getName()%>">
                        <%=sClasses[0].getSinglePerson(1).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(0).getName()%>">
                        <%=sClasses[1].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(1).getName()%>">
                        <%=sClasses[1].getSinglePerson(1).getName()%>
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                请选择上个月<b>倒数第一天</b>上班的人
            </td>
        </tr>
        <tr>
            <td>
                白天：
                <select name="lastFirstDayMorning1">
                    <option value="<%=sClasses[0].getSinglePerson(0).getName()%>">
                        <%=sClasses[0].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[0].getSinglePerson(1).getName()%>">
                        <%=sClasses[0].getSinglePerson(1).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(0).getName()%>">
                        <%=sClasses[1].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(1).getName()%>">
                        <%=sClasses[1].getSinglePerson(1).getName()%>
                    </option>
                </select>
                <select name="lastFirstDayMorning2">
                    <option value="无">
                        无
                    </option>
                    <option value="<%=sClasses[0].getSinglePerson(0).getName()%>">
                        <%=sClasses[0].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[0].getSinglePerson(1).getName()%>">
                        <%=sClasses[0].getSinglePerson(1).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(0).getName()%>">
                        <%=sClasses[1].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(1).getName()%>">
                        <%=sClasses[1].getSinglePerson(1).getName()%>
                    </option>
                </select>
            </td>
            <td>
                晚上：
                <select name="lastFirstDayNight">
                    <option value="<%=sClasses[0].getSinglePerson(0).getName()%>">
                        <%=sClasses[0].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[0].getSinglePerson(1).getName()%>">
                        <%=sClasses[0].getSinglePerson(1).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(0).getName()%>">
                        <%=sClasses[1].getSinglePerson(0).getName()%>
                    </option>
                    <option value="<%=sClasses[1].getSinglePerson(1).getName()%>">
                        <%=sClasses[1].getSinglePerson(1).getName()%>
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>选择这个月谁先上夜班</td>
            <td>
                <select name="firstNightWrok">
                    <option value="0">
                        <%=sClasses[0].getSinglePerson(0).getName()%>
                    </option>
                    <option value="1">
                        <%=sClasses[0].getSinglePerson(1).getName()%>
                    </option>
                </select>
            </td>
        </tr>

        <tr>
            <td align="right" colspan="2">
                <input type="submit" value="确定">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
