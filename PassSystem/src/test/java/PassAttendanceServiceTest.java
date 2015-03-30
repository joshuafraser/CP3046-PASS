import org.junit.Ignore;
import org.junit.Test;
import pojo.PassAttendance;
import service.PassAttendanceService;

import java.sql.SQLException;

/**
 * Created by Stuart on 30/03/2015.
 */
public class PassAttendanceServiceTest implements JUnitTestInterface {
    PassAttendanceService pa = new PassAttendanceService();
    @Ignore
    @Test
    @Override
    public void testAdd() throws SQLException {
        pa.addPassAttendance(new PassAttendance(3, 6, true));
    }
    @Ignore
    @Test
    @Override
    public void testUpdate() throws SQLException {
        pa.updatePassAttendance(1, 3, 6, false);
    }
    @Ignore
    @Test
    @Override
    public void testFindSingle() throws SQLException {
        System.out.println(pa.findPassAttendanceId(1));
    }
    @Ignore
    @Test
    @Override
    public void testFindAll() throws SQLException {
        System.out.println(pa.findAllPassAttendances().size());
    }
    @Ignore
    @Test
    @Override
    public void testDelete() throws SQLException {
        pa.deletePassAttendance(1);
    }
}
