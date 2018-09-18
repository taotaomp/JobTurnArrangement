package cn.PApudding.Servlet;

import cn.PApudding.Schedule.MonthGet;
import cn.PApudding.Schedule.SingleDay;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class DayOffSetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MonthGet monthGet = (MonthGet) session.getAttribute("MonthGet");
        List<SingleDay> singleDays = monthGet.getSingleDays();
        Iterator<SingleDay> iterator;

        Enumeration<String> checkBoxValues = req.getParameterNames();

        while (checkBoxValues.hasMoreElements()) {
            String currentValue = checkBoxValues.nextElement();
            iterator = singleDays.iterator();   //获得新的迭代器
            while (iterator.hasNext()) {
                SingleDay currentDay = iterator.next();
                //将与CheckBox选中的天数的是否为休息日设置为true
                if (currentDay.getDateNum() == Integer.parseInt(currentValue)) {
                    currentDay.isDayOff = true;
                    break;
                }
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/TurnSet.jsp");
        requestDispatcher.forward(req,resp);
    }
}
