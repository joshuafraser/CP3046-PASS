package pojo;

import javax.persistence.*;

@Entity
@Table
public class PassAttendance {

    public PassAttendance() {
    }

    @Id
    private int attendId;
    private int stuId;
    private int sessionId;
    private boolean attendStatus;

    public PassAttendance(int stuId, int sessionId, boolean attendStatus) {
        this.stuId = stuId;
        this.sessionId = sessionId;
        this.attendStatus = attendStatus;
    }

    public int getAttendId() {
        return attendId;
    }

    public void setAttendId(int attendId) {
        this.attendId = attendId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int studId) {
        this.stuId = studId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public boolean isAttendStatus() {
        return attendStatus;
    }

    public void setAttendStatus(boolean attendStatus) {
        this.attendStatus = attendStatus;
    }

    @Override
    public String toString() {
        return "PassAttendance{" +
                "attendId=" + attendId +
                ", stuId=" + stuId +
                ", sessionId=" + sessionId +
                ", attendStatus=" + attendStatus +
                '}';
    }
}