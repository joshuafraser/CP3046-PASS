package pojo;

import javax.persistence.*;

/**
 * Created by Stuart on 29/03/2015.
 */

@Entity
@Table
public class Semester {

    public Semester() {
    }

    @Id
    private int semesterId;
    private int campusId;
    private String semesterName;

    public Semester(int campusId, String semesterName) {
        this.campusId = campusId;
        this.semesterName = semesterName;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "semesterId=" + semesterId +
                ", campusId=" + campusId +
                ", semesterName='" + semesterName + '\'' +
                '}';
    }
}
