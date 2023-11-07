package calendar.calendar_service.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduleResponseDTO {
    public int scheduleID;
    public String userID;
    public String scheduleName;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
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

    public LocalDateTime startTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime endTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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

    public ScheduleTime time() {
        return time;
    }

    public void setTime(ScheduleTime time) {
        this.time = time;
    }

    public String sendtStatTime(LocalDateTime StartDateTime ){
        time = new ScheduleTime();
        time.StartYear = String.valueOf(StartDateTime.getYear());
        time.StartMonth = String.format("%02d", StartDateTime.getMonthValue()); // Padded with zero if needed
        time.StartDay = String.format("%02d", StartDateTime.getDayOfMonth());
        time.StartHour = String.format("%02d", StartDateTime.getHour());
        time.StartMin= String.format("%02d", StartDateTime.getMinute());
        //ex) "2021-11-05 13:47:13.248";
        String Date = time.StartYear+"-"+time.StartMonth+"-"+time.StartDay+" "+time.StartHour+":"+time.StartMin;
        return Date;
    }

    public String sendEndTime(LocalDateTime EndDateTime){
        time.EndYear = String.valueOf(EndDateTime.getYear());
        time.EndMonth = String.format("%02d", EndDateTime.getMonthValue()); // Padded with zero if needed
        time.EndDay = String.format("%02d", EndDateTime.getDayOfMonth());
        time.EndHour = String.format("%02d", EndDateTime.getHour());
        time.EndMin= String.format("%02d", EndDateTime.getMinute());

        //ex) "2021-11-05 13:47:13.248";
        String Date = time.EndYear+"-"+time.EndMonth+"-"+time.EndDay+" "+time.EndHour+":"+time.EndMin;
        return Date;
    }
}
