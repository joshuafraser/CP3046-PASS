package pojo;

import javax.persistence.*;

/**
 * Created by Stuart on 29/03/2015.
 */

@Entity
@Table
public class Subject {

    public Subject() {
    }

    @Id
    private int subId;
    private int semesterId;
    private String subCode;
    private String subName;

    public Subject(int semesterId, String subCode, String subName) {
        super();
        this.semesterId = semesterId;
        this.subCode = subCode;
        this.subName = subName;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subId=" + subId +
                ", semesterId=" + semesterId +
                ", subCode=" + subCode +
                ", subName='" + subName + '\'' +
                '}';
    }
}
