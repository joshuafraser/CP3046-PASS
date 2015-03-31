package pojo;

import javax.persistence.*;

@Entity
@Table
public class Week {

    public Week() {
    }

    @Id
    private int weekId;
    private int semesterId;
    private String weekName;

    public Week(int semesterId, String weekName) {
        this.semesterId = semesterId;
        this.weekName = weekName;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getWeekName() {
        return weekName;
    }

    public void setWeekName(String weekName) {
        this.weekName = weekName;
    }

    @Override
    public String toString() {
        return "Week{" +
                "weekId=" + weekId +
                ", semesterId=" + semesterId +
                ", weekName=" + weekName +
                '}';
    }
}