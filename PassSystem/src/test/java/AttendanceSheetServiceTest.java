import org.junit.Ignore;
import org.junit.Test;
import pojo.AttendanceSheet;
import service.AttendanceSheetService;

import java.sql.SQLException;

/**
 * Created by Stuart on 30/03/2015.
 */
public class AttendanceSheetServiceTest implements JUnitTestInterface {
    AttendanceSheetService as = new AttendanceSheetService();

    @Ignore
    @Test
    @Override
    public void testAdd() throws SQLException {
        as.addAttendanceSheet(new AttendanceSheet(6, true));
    }
    @Ignore
    @Test
    @Override
    public void testUpdate() throws SQLException {
        as.updateAttendanceSheet(3, 6, false);

    }
    @Ignore
    @Test
    @Override
    public void testFindSingle() throws SQLException {
        System.out.println(as.findAttendanceSheetById(3));
    }
    @Ignore
    @Test
    @Override
    public void testFindAll() throws SQLException {
        System.out.println(as.findAllAttendanceSheets().size());
    }
    @Ignore
    @Test
    @Override
    public void testDelete() throws SQLException {
        as.deleteAttendanceSheet(3);
    }
}
