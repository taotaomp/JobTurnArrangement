package cn.PApudding.Servlet;

import cn.PApudding.People.SingleClass;
import cn.PApudding.People.SinglePerson;
import cn.PApudding.Schedule.MonthGet;
import cn.PApudding.Schedule.SingleDay;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class PeopleSetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MonthGet monthGet = (MonthGet) session.getAttribute("MonthGet");
        SingleClass[] sClasses = (SingleClass[]) session.getAttribute("sClasses");

        //上月倒数第二天
        String lastSecondDayMorning1 = new String(req.getParameter("lastSecondDayMorning1").getBytes("ISO-8859-1"), "gb2312");
        String lastSecondDayMorning2 = new String(req.getParameter("lastSecondDayMorning2").getBytes("ISO-8859-1"), "gb2312");
        String lastSecondDayNight = new String(req.getParameter("lastSecondDayNight").getBytes("ISO-8859-1"), "gb2312");
        //上月倒数第一天
        String lastFirstDayMorning1 = new String(req.getParameter("lastFirstDayMorning1").getBytes("ISO-8859-1"), "gb2312");
        String lastFirstDayMorning2 = new String(req.getParameter("lastFirstDayMorning2").getBytes("ISO-8859-1"), "gb2312");
        String lastFirstDayNight = new String(req.getParameter("lastFirstDayNight").getBytes("ISO-8859-1"), "gb2312");
        //本月谁先上晚班
        String firstNightWork = new String(req.getParameter("firstNightWrok").getBytes("ISO-8859-1"), "gb2312");

        SingleClass firstDayClass;   //本月第一天上班的是哪个班
        SinglePerson firstDayNightPerson;   //本月第一天上晚班的是哪个人
        int turnCount = -1;          //用来记录一个组中已上班的天数
        boolean isFirstTurn = true;     //默认开启第一次，1班夜班人转变

        if (sClasses[0].isContainPerson(lastSecondDayMorning1)) {
            //上月倒数第二天上班的人是1班的人
            if (sClasses[0].isContainPerson(lastFirstDayMorning1)) {
                //上月倒数第一天上班的人是1班的人
                firstDayClass = sClasses[1];    //所以本月第一天上班的是2班
                firstDayNightPerson = firstDayClass.getSinglePerson(0); //且是2班的第1人
                turnCount = 0;      //该组还未上班，所以为0
                isFirstTurn = false;    //关闭转变
            } else {
                //上月倒数第一天上班的人是2班的人
                firstDayClass = sClasses[1];    //所以本月第一天上班的是2班
                turnCount = 1;      //该组上过1天班了，所以为1
                if (lastFirstDayNight.equals(sClasses[1].getSinglePerson(0).getName())) {
                    //上月倒数第一天上晚班的人是2班的第1人
                    firstDayNightPerson = firstDayClass.getSinglePerson(1);     //所以本月第一天上晚班的是2班的第2人

                } else {
                    //上月倒数第一天上晚班的人是2班的第2人
                    firstDayNightPerson = firstDayClass.getSinglePerson(0);     //所以本月第一天上晚班的是2班的第1人

                }
                isFirstTurn = false;
            }
        } else {
            //上月倒数第二天上班的人是2班的人
            if (sClasses[0].isContainPerson(lastFirstDayMorning1)) {
                //上月倒数第一天上班的人是1班的人
                firstDayClass = sClasses[0];    //所以本月第一天上班的是1班
                turnCount = 1;      //该组上过1天班了，所以为1
                if (lastFirstDayNight.equals(sClasses[0].getSinglePerson(0).getName())) {
                    //上月倒数第一天上晚班的人是1班的第1人
                    firstDayNightPerson = firstDayClass.getSinglePerson(1);     //所以本月第一天上晚班的是1班的第2人
                    firstNightWork = "0";		//这里虽然第一天上晚班的是第二人，但实际在整个轮回中，是第一人先上的晚班，下一次依然该第二人先上晚班。下同
                } else {
                    //上月倒数第一天上晚班的人是1班的第2人
                    firstDayNightPerson = firstDayClass.getSinglePerson(0);     //所以本月第一天上晚班的是1班的第1人
                    firstNightWork = "1";
                }
            } else {
                //上月倒数第一天上班的人是2班的人
                firstDayClass = sClasses[0];    //所以本月第一天上班的是1班
                //判断1班第一天上夜班的是谁
                if (Integer.parseInt(firstNightWork) == 0) {
                    firstDayNightPerson = firstDayClass.getSinglePerson(0); //是1班的第1人
                } else {
                    firstDayNightPerson = firstDayClass.getSinglePerson(1); //是1班的第2人
                }
                turnCount = 0;      //该组还未上班，所以为0
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("<table border='1'>");

        result.append("<tr>");
        result.append("<td>");
        result.append("泸州市档案局门卫值守排班表\n");
        result.append("</td>");
        result.append("</tr>");

        result.append("<tr>");
        result.append("<td>");
        result.append(monthGet.showYearAndMonth()[0] + "年" + monthGet.showYearAndMonth()[1] + "月\n");
        result.append("</td>");
        result.append("</tr>");

        result.append("<tr>");
        result.append("<td>");
        result.append("日期");
        result.append("</td>");
        result.append("<td>");
        result.append("上午：8:00~下午18:00");
        result.append("</td>");
        result.append("<td>");
        result.append("下午：18:00～次日上午：8:00");
        result.append("</td>");
        result.append("</tr>");
        //result.append("日期\t上午：8:00~下午18:00\t下午：18:00～次日上午：8:00\n");

        List<SingleDay> singleDays = monthGet.getSingleDays();
        Iterator<SingleDay> iterator = singleDays.iterator();

        SingleClass currentClass = firstDayClass;
        SinglePerson currentNightPerson = firstDayNightPerson;
        String currentClass1FirstNightWork = firstNightWork;

        while (iterator.hasNext()) {
            turnCount++;    //已上班计数+1
            SingleDay currentDay = iterator.next();     //当前日

            if (turnCount == 1) {
                //等于1表示改组人员是第1天开始工作
                //判断当日是否为休息日
                if (currentDay.isDayOff) {
                    //当前日是休息日
                    //判断当前日是周末还是周日
                    String weekend;
                    if (currentDay.getDayOfWeek() == 6) {
                        weekend = "周六";
                    } else if (currentDay.getDayOfWeek() == 7) {
                        weekend = "周日";
                    } else {
                        weekend = "节假日";
                    }

                    /*result.append(currentDay.getDateNum() + "   " + weekend + "\t"
                            + currentNightPerson.getName() + "\t"
                            + currentNightPerson.getName()
                            + "\n"
                    );*/
                    result.append("<tr>");
                    result.append("<td>");
                    result.append(currentDay.getDateNum() + "   " + weekend);
                    result.append("</td>");
                    result.append("<td>");
                    result.append(currentNightPerson.getName());
                    result.append("</td>");
                    result.append("<td>");
                    result.append(currentNightPerson.getName());
                    result.append("</td>");
                    result.append("</tr>");

                } else {
                    //当前日是工作日
                    /*result.append(currentDay.getDateNum() + "   " + "\t"
                            + currentClass.getSinglePerson(0).getName() + "    " + currentClass.getSinglePerson(1).getName() + "\t"
                            + currentNightPerson.getName()
                            + "\n"
                    );*/
                    result.append("<tr>");
                    result.append("<td>");
                    result.append(currentDay.getDateNum() + "   ");
                    result.append("</td>");
                    result.append("<td>");
                    result.append(currentClass.getSinglePerson(0).getName() + "    " + currentClass.getSinglePerson(1).getName());
                    result.append("</td>");
                    result.append("<td>");
                    result.append(currentNightPerson.getName());
                    result.append("</td>");
                    result.append("</tr>");
                }

            } else if (turnCount == 2) {
                //等于2表示改组人员已经工作了1天，这是第2天
                //切换夜班工作人员
                if(currentDay.getDateNum()!=1){
                    //第一天不切换，切换出bug
                    if (currentNightPerson.getName().equals(currentClass.getSinglePerson(0).getName())) {
                        currentNightPerson = currentClass.getSinglePerson(1);
                    } else {
                        currentNightPerson = currentClass.getSinglePerson(0);
                    }
                }
                //判断当日是否为休息日
                if (currentDay.isDayOff) {
                    //当前日是休息日
                    //判断当前日是周末还是周日
                    String weekend;
                    if (currentDay.getDayOfWeek() == 6) {
                        weekend = "周六";
                    } else if (currentDay.getDayOfWeek() == 7) {
                        weekend = "周日";
                    } else {
                        weekend = "节假日";
                    }


                    /*result.append(currentDay.getDateNum() + "   " + weekend + "\t"
                            + currentNightPerson.getName() + "\t"
                            + currentNightPerson.getName()
                            + "\n"
                    );*/
                    result.append("<tr>");
                    result.append("<td>");
                    result.append(currentDay.getDateNum() + "   " + weekend);
                    result.append("</td>");
                    result.append("<td>");
                    result.append(currentNightPerson.getName());
                    result.append("</td>");
                    result.append("<td>");
                    result.append(currentNightPerson.getName());
                    result.append("</td>");
                    result.append("</tr>");

                } else {
                    //当前日是工作日
                    /*result.append(currentDay.getDateNum() + "   " + "\t"
                            + currentClass.getSinglePerson(0).getName() + "    " + currentClass.getSinglePerson(1).getName() + "\t"
                            + currentNightPerson.getName()
                            + "\n"
                    );*/
                    result.append("<tr>");
                    result.append("<td>");
                    result.append(currentDay.getDateNum() + "   ");
                    result.append("</td>");
                    result.append("<td>");
                    result.append(currentClass.getSinglePerson(0).getName() + "    " + currentClass.getSinglePerson(1).getName());
                    result.append("</td>");
                    result.append("<td>");
                    result.append(currentNightPerson.getName());
                    result.append("</td>");
                    result.append("</tr>");
                }

                //将turnCount重置
                turnCount = 0;
                //切换当前班
                if (currentClass.getClassName().equals(sClasses[0].getClassName())) {
                    currentClass = sClasses[1];
                } else {
                    currentClass = sClasses[0];
                }
                //切换下一班的夜班值班人
                if (currentClass.getClassName().equals(sClasses[0].getClassName())) {
                    //如果下一班是1班
                    if (isFirstTurn == true) {      //第一次不转变，然后接下来便开始转变
                        if (currentClass1FirstNightWork.equals("0")) {
                            currentNightPerson = currentClass.getSinglePerson(1);
                            currentClass1FirstNightWork = "1";
                        } else {
                            currentNightPerson = currentClass.getSinglePerson(0);
                            currentClass1FirstNightWork = "0";
                        }
                    } else {
                        isFirstTurn = true;
                        if (currentClass1FirstNightWork.equals("0")) {
                            currentNightPerson = currentClass.getSinglePerson(0);
                        } else {
                            currentNightPerson = currentClass.getSinglePerson(1);
                        }
                    }

                } else {
                    //如果下一班是2班
                    currentNightPerson = currentClass.getSinglePerson(0);
                }

            }
        }
        result.append("</table>");
        //结果输出
        //resp.setContentType("application/vnd.ms-excel;charset=gb2312");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<meta name=\"viewport\" content=\"width=device-width,minimum-scale=1.0, maximum-scale=2.0\" />");
        out.println(result.toString());

        session.invalidate();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
