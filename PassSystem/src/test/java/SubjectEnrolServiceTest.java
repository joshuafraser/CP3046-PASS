import org.junit.Ignore;
import org.junit.Test;
import pojo.SubjectEnrol;
import service.SubjectEnrolService;

import java.sql.SQLException;

public class SubjectEnrolServiceTest implements JUnitTestInterface {

    SubjectEnrolService se = new SubjectEnrolService();

    @Ignore
    @Test
    @Override
    public void testAdd() throws SQLException {
        se.addSubjectEnrol(new SubjectEnrol(15,3));
    }

    @Ignore
    @Override
    public void testUpdate() throws SQLException {

    }

    @Ignore
    @Test
    @Override
    public void testFindSingle() throws SQLException {
        System.out.println(se.findSubjectEnrolById(5));
    }

    @Ignore
    @Test
    @Override
    public void testFindAll() throws SQLException {
        System.out.println(se.findAllSubjectEnrol().size());
    }

    @Ignore
    @Test
    @Override
    public void testDelete() throws SQLException {
        se.deleteSubjectEnrol(5);
    }
}