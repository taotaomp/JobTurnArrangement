package cn.PApudding.Servlet;

import cn.PApudding.Schedule.MonthGet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MonthGetServlet extends HttpServlet {
    private MonthGet monthGet = new MonthGet();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String yearAndMonth = req.getParameter("yearAndMonth");
        if(yearAndMonth == null){
            return;
        }
        String[] temp = yearAndMonth.split("-");
        monthGet.setYearAndMonth(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));

        HttpSession session = req.getSession();

        session.setAttribute("MonthGet",monthGet);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/DayOffSet.jsp");
        dispatcher.forward(req,resp);
    }
}
