import org.junit.Ignore;
import org.junit.Test;
import pojo.Semester;
import service.SemesterService;

import java.sql.SQLException;

public class SemesterServiceTest implements JUnitTestInterface{

    SemesterService ss = new SemesterService();

    @Ignore
    @Override
    @Test
    public void testAdd() throws SQLException {
        ss.addSemester(new Semester(9, "crazyTest"));
    }

    @Ignore
    @Override
    @Test
    public void testUpdate() throws SQLException {
        ss.updateSemester(5, 10, "ammended");
    }

    @Ignore
    @Override
    @Test
    public void testFindSingle() throws SQLException {
        System.out.println(ss.findSemesterById(5));
    }

    @Ignore
    @Override
    @Test
    public void testFindAll() throws SQLException {
        System.out.println(ss.findAllSemesters().size());

    }

    @Ignore
    @Override
    @Test
    public void testDelete() throws SQLException {

        ss.deleteSemester(5);

    }
}