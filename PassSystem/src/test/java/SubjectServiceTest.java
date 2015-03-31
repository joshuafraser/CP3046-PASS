import org.junit.Ignore;
import org.junit.Test;
import pojo.Subject;
import service.SubjectService;

import java.sql.SQLException;

public class SubjectServiceTest implements JUnitTestInterface{

    SubjectService ss = new SubjectService();

    @Ignore
    @Override
    @Test
    public void testAdd() throws SQLException {

        ss.addSubject(new Subject(4, "CPtest", "whatever"));
    }

    @Ignore
    @Override
    @Test
    public void testUpdate() throws SQLException {
        ss.updateSubject(14, 4, "CPamen", "ammended");

    }

    @Ignore
    @Override
    @Test
    public void testFindSingle() throws SQLException {
        System.out.println(ss.findSubjectById(14));
    }

    @Ignore
    @Override
    @Test
    public void testFindAll() throws SQLException {
        System.out.println(ss.findAllSubjects().size());
    }

    @Ignore
    @Override
    @Test
    public void testDelete() throws SQLException {
        ss.deleteSubject(14);
    }
}