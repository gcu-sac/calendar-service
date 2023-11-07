package calendar.calendar_service.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Schedule {
    public int scheduleID;
    public String userID;
    public String scheduleName;
    public String scheduleDesc;
    public ScheduleTime time;


    public int scheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String scheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String scheduleDesc() {
        return scheduleDesc;
    }

    public void setScheduleDesc(String scheduleDesc) {
        this.scheduleDesc = scheduleDesc;
    }

    public String userID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public LocalDateTime convertStatTime(){
        //ex) "2021-11-05 13:47:13.248";
        String startTime = time.StartYear+"-"+time.StartMonth+"-"+time.StartDay+" "+time.StartHour+":"+time.StartMin+":00.000";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(startTime, formatter);
        return dateTime;
    }

    public LocalDateTime convertEndTime(){
        //ex) "2021-11-05 13:47:13.248";
        String endTime = time.EndYear+"-"+time.EndMonth+"-"+time.EndDay+" "+time.EndHour+":"+time.EndMin+":00.000";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(endTime, formatter);
        return dateTime;
    }
}
