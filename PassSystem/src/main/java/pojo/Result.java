package pojo;

import javax.persistence.*;

/**
 * Created by Stuart on 29/03/2015.
 */

@Entity
@Table
public class Result {

    public Result() {
    }

    @Id
    private int resultId;
    private int stuId;
    private int subId;
    private String resultGrade;
    private double resultPercentage;

    public Result(int stuId, int subId, String resultGrade, double resultPercentage) {
        this.stuId = stuId;
        this.subId = subId;
        this.resultGrade = resultGrade;
        this.resultPercentage = resultPercentage;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getResultGrade() {
        return resultGrade;
    }

    public void setResultGrade(String resultGrade) {
        this.resultGrade = resultGrade;
    }

    public double getResultPercentage() {
        return resultPercentage;
    }

    public void setResultPercentage(double resultPercentage) {
        this.resultPercentage = resultPercentage;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultId=" + resultId +
                ", stuId=" + stuId +
                ", subId=" + subId +
                ", resultGrade='" + resultGrade + '\'' +
                ", resultPercentage=" + resultPercentage +
                '}';
    }
}
