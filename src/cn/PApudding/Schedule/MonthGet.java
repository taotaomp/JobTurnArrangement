package cn.PApudding.Schedule;

import java.util.*;

public class MonthGet {
    private Calendar calendar;

    public List<SingleDay> getSingleDays() {
        return singleDays;
    }

    private List<SingleDay> singleDays = new ArrayList<>();

    public MonthGet() {
        calendar = Calendar.getInstance();
    }

    private int year;
    private int month;

    /**
     * 设置年月
     *
     * @param year
     * @param month
     */
    public void setYearAndMonth(int year, int month) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);  //Calendar中0表示1月
        this.year = year;
        this.month = month;
    }

    /**
     * 展示年月
     *
     * @return int[] 0:year 1:month
     */
    public int[] showYearAndMonth() {
        int[] yearAndMonth = new int[2];
        //yearAndMonth[0] = calendar.get(Calendar.YEAR);
        //yearAndMonth[1] = calendar.get(Calendar.MONTH) + 1; //Calendar中1月为0
        yearAndMonth[0] = year;
        yearAndMonth[1] = month;
        return yearAndMonth;
    }

    /**
     * 生成日历
     *
     */
    public void calendarGenerate() {
        singleDays.clear();     //将容器清空
        calendar.set(Calendar.DAY_OF_MONTH, 1);  //将日期设置为当前月的第一天

        for (int i = 0; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            SingleDay currentDay = new SingleDay();

            currentDay.setDateNum(calendar.get(Calendar.DAY_OF_MONTH));
            currentDay.setDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK) - 1);  //SUN:1|MON:2|TUE:3|WED:4|THU:5|FRI:6|SAT:7
            //获取当天是星期几，若是周末则设置周末
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                currentDay.isDayOff = true;
            }
            singleDays.add(currentDay);
            //将日期往后推一天
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
