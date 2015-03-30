import org.junit.Ignore;
import org.junit.Test;
import pojo.Session;
import service.SessionService;

import java.sql.SQLException;

/**
 * Created by Stuart on 30/03/2015.
 */
public class SessionServiceTest implements JUnitTestInterface {
    SessionService ss = new SessionService();
    @Ignore
    @Test
    @Override
    public void testAdd() throws SQLException {

        ss.addSession(new Session(15, 7, "test session", "testdate", 5));
    }
    @Ignore
    @Override
    @Test
    public void testUpdate() throws SQLException {
        ss.updateSession(6, 15, 7, "ammended", "ammended", 5);
    }
    @Ignore
    @Test
    @Override
    public void testFindSingle() throws SQLException {
        System.out.println(ss.findSessionById(6));
    }
    @Ignore
    @Test
    @Override
    public void testFindAll() throws SQLException {
        System.out.println(ss.findAllSessions().size());
    }
    @Ignore
    @Test
    @Override
    public void testDelete() throws SQLException {
        ss.deleteSession(10);

    }
}
