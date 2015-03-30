package utilities;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Stuart on 29/03/2015.
 */
public class PersistenceManager {
    public static final boolean DEBUG = true;

    private static final PersistenceManager singleton = new PersistenceManager();

    protected EntityManagerFactory emf;

    public static PersistenceManager getInstance() {

        return singleton;
    }

    private PersistenceManager() {
    }

    public EntityManagerFactory getEntityManagerFactory() {

        if (emf == null)
            createEntityManagerFactory();
        return emf;
    }

    public void closeEntityManagerFactory() {

        if (emf != null) {
            emf.close();
            emf = null;
            if (DEBUG)
                System.out.println("n*** Persistence finished at " + new java.util.Date());
        }
    }

    protected void createEntityManagerFactory() {

        this.emf = Persistence.createEntityManagerFactory("passSystemManager1");
        if (DEBUG)
            System.out.println("n*** Persistence started at " + new java.util.Date());
    }

}
