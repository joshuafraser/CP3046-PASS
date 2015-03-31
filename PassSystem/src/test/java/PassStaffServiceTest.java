import org.junit.Ignore;
import org.junit.Test;
import pojo.PassStaff;
import service.PassStaffService;

import java.sql.SQLException;

public class PassStaffServiceTest implements JUnitTestInterface {

    PassStaffService ps = new PassStaffService();

    @Ignore
    @Override
    @Test
    public void testAdd() throws SQLException {
        ps.addPassStaff(new PassStaff("testFName", "testLName"));

    }

    @Ignore
    @Override
    @Test
    public void testUpdate() throws SQLException {
        ps.updatePassStaff(5, "testAmmend", "testAmmend");
    }

    @Ignore
    @Override
    @Test
    public void testFindSingle() throws SQLException {
        System.out.println(ps.findPassStaffById(5));
    }

    @Ignore
    @Override
    @Test
    public void testFindAll() throws SQLException {
        System.out.println(ps.findAllPassStaff().size());
    }

    @Ignore
    @Override
    @Test
    public void testDelete() throws SQLException {
        ps.deletePassStaff(6);
    }
}