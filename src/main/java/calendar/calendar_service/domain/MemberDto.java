package calendar.calendar_service.domain;

import java.util.ArrayList;
import java.util.List;

public class MemberDto {
    String MemberID;
    ArrayList<String> Members = new ArrayList();

    public String MemberID() {
        return MemberID;
    }

    public void setMemberID(String memberID) {
        MemberID = memberID;
    }

    public ArrayList<String> Members() {
        return Members;
    }

    public void setMembers(ArrayList<String> members) {
        Members = members;
    }
}
