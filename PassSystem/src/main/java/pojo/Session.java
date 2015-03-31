package pojo;

import javax.persistence.*;

@Entity
@Table
public class Session {

    public Session() {
    }

    @Id
    private int sessionId;
    private int subId;
    private int staffId;
    private String sessionName;
    private String sessionDate;
    private int weekId;

    public Session(int subId, int staffId, String sessionName, String sessionDate, int weekId) {
        this.subId = subId;
        this.staffId = staffId;
        this.weekId = weekId;
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", subId=" + subId +
                ", staffId=" + staffId +
                ", sessionName='" + sessionName + '\'' +
                ", sessionDate='" + sessionDate + '\'' +
                ", weekId=" + weekId +
                '}';
    }
}