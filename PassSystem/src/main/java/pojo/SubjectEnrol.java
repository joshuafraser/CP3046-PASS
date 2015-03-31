package pojo;

import javax.persistence.*;

@Entity
@Table
public class SubjectEnrol {

    public SubjectEnrol() {
    }

    @Id
    private int enrolId;
    private int subId;
    private int stuId;

    public SubjectEnrol(int subId, int stuId) {
        this.subId = subId;
        this.stuId = stuId;
    }

    public int getEnrolId() {
        return enrolId;
    }

    public void setEnrolId(int enrolId) {
        this.enrolId = enrolId;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Override
    public String toString() {
        return "SubjectEnrol{" +
                "enrolId=" + enrolId +
                ", subId=" + subId +
                ", stuId=" + stuId +
                '}';
    }
}