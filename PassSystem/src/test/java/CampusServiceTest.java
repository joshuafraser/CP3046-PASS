import org.junit.Ignore;
import org.junit.Test;
import pojo.Campus;
import service.CampusService;

import java.sql.SQLException;

public class CampusServiceTest implements JUnitTestInterface {

    CampusService cs = new CampusService();

    @Ignore
    @Test
    public void testAdd()throws SQLException{
        Campus c = new Campus("Test");
        System.out.println(c.toString());
        cs.addCampus(c);
    }

    @Ignore
    @Test
    public void testUpdate() throws SQLException{
        cs.updateCampus(6, "After Update");
    }

    @Ignore
    @Test
    public void testFindSingle() throws SQLException{
        System.out.println(cs.findCampusById(4).toString());
    }

    @Ignore
    @Test
    public void testFindAll() throws SQLException{
        System.out.println(cs.findAllCampuses().size());
    }

    @Ignore
    @Test
    public void testDelete() throws SQLException{
        cs.deleteCampus(6);
    }

}