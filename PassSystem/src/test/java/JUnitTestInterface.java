import org.junit.Test;
import pojo.Campus;

import java.sql.SQLException;

/**
 * Created by Stuart on 29/03/2015.
 */
public interface JUnitTestInterface {


    void testAdd()throws SQLException;



    public void testUpdate() throws SQLException;


    public void testFindSingle() throws SQLException;




    public void testFindAll() throws SQLException;



    public void testDelete() throws SQLException;

}
