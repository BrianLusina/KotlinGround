package meetup.src.main.java;

import org.joda.time.DateTime;

public class Meetup {

    /*fields*/
    private int month;
    private int year;

    /*constructor*/
    public Meetup(int month, int year){
        this.month = month;
        this.year = year;
    }

    public DateTime day(int wkday, MeetupSchedule time){
        DateTime day;
        switch(time){
            case FIRST:
                day = findDate(wkday,1,7,1);
                break;
            case SECOND:
                day = findDate(wkday,8,14,1);
                break;
            case THIRD:
                day = findDate(wkday,15,21,1);
                break;
            case FOURTH:
                day = findDate(wkday,22,28,1);
                break;
            case LAST:
                int daysInMth = new DateTime(getYear(), getMonth(),1,0,0).dayOfMonth().getMaximumValue();
                day = findDate(wkday,daysInMth,daysInMth-7,-1);
                break;
            case TEENTH:
                day = findDate(wkday,13,19,1);
                break;
            default:
                throw new IllegalArgumentException("Not valid");
        }
        return day;
    }

    private DateTime findDate(int weekDay, int start, int stop, int step){
        DateTime dy = new DateTime(getYear(), getMonth(), start, 0, 0);
        for(;dy.getDayOfMonth() != stop+step; dy.plusDays(step)){
            if(dy.getDayOfWeek() == weekDay)
                break;
        }
        return dy;
    }

    /*getters and setters*/
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

/*CLASS END*/
}
