package calendar.calendar_service.domain;

import java.time.LocalDateTime;

public class SendSchedule {

    public int scheduleID;
    public String userID;
    public String scheduleName;
    public String startTime;
    public String endTime;
    public String scheduleDesc;

    public int scheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String userID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String scheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String startTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String endTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String scheduleDesc() {
        return scheduleDesc;
    }

    public void setScheduleDesc(String scheduleDesc) {
        this.scheduleDesc = scheduleDesc;
    }
}
