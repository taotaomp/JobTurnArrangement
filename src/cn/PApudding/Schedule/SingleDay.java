package cn.PApudding.Schedule;

public class SingleDay {
    private int dateNum;

    public int getDateNum() {
        return dateNum;
    }

    public void setDateNum(int dateNum) {
        this.dateNum = dateNum;
    }

    public boolean isDayOff;

    private int dayOfWeek;

    /**
     * MON:1|TUE:2|WED:3|THU:4|FRI:5|SAT:6|SUN:7
     * @return
     */
    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        if(dayOfWeek == 0){
            this.dayOfWeek = 7;
            return;
        }
        this.dayOfWeek = dayOfWeek;
    }
}
