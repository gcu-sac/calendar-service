package calendar.calendar_service.domain;

import java.time.LocalDateTime;

public class Schedule {
    public int scheduleId;
    public String scheduleName;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public String schedulDesc;
    public String groupId;
    //private String scheduleColor;

    public int scheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
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

    public String schedulDesc() {
        return schedulDesc;
    }

    public void setSchedulDesc(String schedulDesc) {
        this.schedulDesc = schedulDesc;
    }

    public String groupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
/*
    public String scheduleColor() {
        return scheduleColor;
    }

    public void setScheduleColor(String scheduleColor) {
        this.scheduleColor = scheduleColor;
    }

 */
}
