package pojo;

import javax.persistence.*;

/**
 * Created by Stuart on 29/03/2015.
 */

@Entity
@Table
public class Campus {

    public Campus() {
    }

    @Id
    private int campusId;
    private String campusName;

    public Campus(String campusName) {
        super();
        this.campusName = campusName;
    }

    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "campusId=" + campusId +
                ", campusName='" + campusName + '\'' +
                '}';
    }
}
