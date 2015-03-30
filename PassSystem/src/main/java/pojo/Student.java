package pojo;

import javax.persistence.*;

/**
 * Created by Stuart on 29/03/2015.
 */

@Entity
@Table
public class Student {

    public Student() {
    }

    @Id
    private int stuId;
    private String stuFname;
    private String stuLName;

    public Student(String stuFname, String stuLName) {
        this.stuFname = stuFname;
        this.stuLName = stuLName;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int studId) {
        this.stuId = studId;
    }

    public String getStuFname() {
        return stuFname;
    }

    public void setStuFname(String stuFname) {
        this.stuFname = stuFname;
    }

    public String getStuLName() {
        return stuLName;
    }

    public void setStuLName(String stuLName) {
        this.stuLName = stuLName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studId=" + stuId +
                ", stuFname=" + stuFname +
                ", stuLName=" + stuLName +
                '}';
    }
}
