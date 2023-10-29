package calendar.calendar_service.domain;

public class GroupDto {
    String GroupID;
    String LeaderID;
    String GroupName;
    String MemberID;
    String ScheduleID;


    public String GroupID() {
        return GroupID;
    }

    public void setGroupID(String groupID) {
        GroupID = groupID;
    }

    public String LeaderID() {
        return LeaderID;
    }

    public void setLeaderID(String leaderID) {
        LeaderID = leaderID;
    }

    public String GroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public String MemberID() {
        return MemberID;
    }

    public void setMemberID(String memberID) {
        MemberID = memberID;
    }

    public String ScheduleID() {
        return ScheduleID;
    }

    public void setScheduleID(String scheduleID) {
        ScheduleID = scheduleID;
    }
}
