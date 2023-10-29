package calendar.calendar_service.domain;

import java.sql.Date;

public class ScheduleDto {
    String scheduleID;
    String scheduleName;
    String scheduleDesc;
    Date StartTime;
    Date EndTime;
    String GroupID;
    //-----------optional
    String ScheduleColor;


    public String scheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
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

    public Date StartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date EndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public String GroupID() {
        return GroupID;
    }

    public void setGroupID(String groupID) {
        GroupID = groupID;
    }

    public String ScheduleColor() {
        return ScheduleColor;
    }

    public void setScheduleColor(String scheduleColor) {
        ScheduleColor = scheduleColor;
    }


}
