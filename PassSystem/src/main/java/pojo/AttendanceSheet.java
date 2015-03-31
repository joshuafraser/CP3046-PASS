package pojo;

import javax.persistence.*;

@Entity
@Table
public class AttendanceSheet {

    public AttendanceSheet() {
    }

    @Id
    private int sheetId;
    private int sessionId;
    private boolean sheetRecorded;

    public AttendanceSheet(int sessionId, boolean sheetRecorded) {
        this.sessionId = sessionId;
        this.sheetRecorded = sheetRecorded;
    }

    public int getSheetId() {
        return sheetId;
    }

    public void setSheetId(int sheetId) {
        this.sheetId = sheetId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public boolean isSheetRecorded() {
        return sheetRecorded;
    }

    public void setSheetRecorded(boolean sheetRecorded) {
        this.sheetRecorded = sheetRecorded;
    }

    @Override
    public String toString() {
        return "AttendanceSheet{" +
                "sheetId=" + sheetId +
                ", sessionId=" + sessionId +
                ", sheetRecorded=" + sheetRecorded +
                '}';
    }
}