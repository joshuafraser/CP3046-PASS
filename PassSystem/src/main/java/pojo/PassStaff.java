package pojo;

import javax.persistence.*;

@Entity
@Table
public class PassStaff {

    public PassStaff() {
    }

    @Id
    private int staffId;
    private String staffFName;
    private String staffLName;

    public PassStaff(String staffFName, String staffLName) {
        this.staffFName = staffFName;
        this.staffLName = staffLName;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffFName() {
        return staffFName;
    }

    public void setStaffFName(String staffName) {
        this.staffFName = staffName;
    }

    public String getStaffLName() {
        return staffLName;
    }

    public void setStaffLName(String staffLName) {
        this.staffLName = staffLName;
    }

    @Override
    public String toString() {
        return "PassStaff{" +
                "staffId=" + staffId +
                ", staffFName='" + staffFName + '\'' +
                ", staffLName='" + staffLName + '\'' +
                '}';
    }
}