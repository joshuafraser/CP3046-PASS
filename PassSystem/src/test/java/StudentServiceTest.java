import org.junit.Ignore;
import org.junit.Test;
import pojo.Student;
import service.StudentService;

import java.sql.SQLException;

public class StudentServiceTest implements JUnitTestInterface {

    StudentService ss = new StudentService();

    @Ignore
    @Override
    @Test
    public void testAdd() throws SQLException {
        ss.addStudent(new Student("test", "test"));
    }

    @Ignore
    @Override
    @Test
    public void testUpdate() throws SQLException {
        ss.updateStudent(3, "ammended", "ammended");
    }

    @Ignore
    @Override
    @Test
    public void testFindSingle() throws SQLException {
        System.out.println(ss.findStudentById(3).toString());

    }

    @Ignore
    @Override
    @Test
    public void testFindAll() throws SQLException {
        System.out.println(ss.findAllStudents().size());
    }

    @Ignore
    @Override
    @Test
    public void testDelete() throws SQLException {

    }
}