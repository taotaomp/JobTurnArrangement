<%@ page import="cn.PApudding.People.SingleClass" %><%--
  Created by IntelliJ IDEA.
  User: papudding
  Date: 18-8-20
  Time: ����5:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="viewport" content="width=device-width,minimum-scale=1.0, maximum-scale=2.0" />
<html>
<head>
    <title>�����ְల��-�ְ����趨</title>
</head>
<body>
    <%
        SingleClass[] sClasses = new SingleClass[2];
        sClasses[0] = new SingleClass("����Ԫ", "�Ὠǿ", "1");
        sClasses[1] = new SingleClass("�����", "ŷ�¿�", "2");

        session = request.getSession();
        session.setAttribute("sClasses",sClasses);
    %>
<form action="PeopleSetServlet" method="post">
    <table border="1">
        <tr>
            <td colspan="2">
                ��ѡ���ϸ���<b>�����ڶ���</b>�ϰ����
            </td>
        </tr>
        <tr>
            <td>
                ���죺
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
                    <option value="��">
                        ��
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
                ���ϣ�
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
                ��ѡ���ϸ���<b>������һ��</b>�ϰ����
            </td>
        </tr>
        <tr>
            <td>
                ���죺
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
                    <option value="��">
                        ��
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
                ���ϣ�
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
            <td>ѡ�������˭����ҹ��</td>
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
                <input type="submit" value="ȷ��">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
