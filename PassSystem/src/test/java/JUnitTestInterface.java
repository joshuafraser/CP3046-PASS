import java.sql.SQLException;

public interface JUnitTestInterface {

    void testAdd()throws SQLException;


    void testUpdate() throws SQLException;


    void testFindSingle() throws SQLException;


    void testFindAll() throws SQLException;

    void testDelete() throws SQLException;

}
