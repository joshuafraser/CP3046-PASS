import org.junit.Ignore;
import org.junit.Test;
import pojo.Result;
import service.ResultService;

import java.sql.SQLException;

/**
 * Created by Stuart on 30/03/2015.
 */
public class ResultServiceTest implements JUnitTestInterface {
    ResultService rs = new ResultService();
    @Ignore
    @Test
    @Override
    public void testAdd() throws SQLException {
        rs.addResult(new Result(3, 15, "D", 80.5));
    }
    @Ignore
    @Test
    @Override
    public void testUpdate() throws SQLException {
        rs.updateResult(4, 3, 15 , "C", 70.9);
    }
    @Ignore
    @Test
    @Override
    public void testFindSingle() throws SQLException {
        System.out.println(rs.findResultById(4));
    }
    @Ignore
    @Test
    @Override
    public void testFindAll() throws SQLException {
        System.out.println(rs.findAllResults().size());
    }
    @Ignore
    @Test
    @Override
    public void testDelete() throws SQLException {
        rs.deleteResult(4);
    }
}
