package service;

import pojo.Campus;
import utilities.PersistenceManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CampusService {

    EntityManagerFactory emf;
    EntityManager em;

    public CampusService() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void addCampus(Campus campus) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(campus);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateCampus(int campusId, String newCampusName) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Campus campus = em.find(Campus.class, campusId);
                campus.setCampusName(newCampusName);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public Campus findCampusById(int campusId) {
        try {
            Campus campus = em.find(Campus.class, campusId);
            return campus;
        } finally {
            em.close();
            emf.close();
        }
    }

    //Fix to use native query does not work as is
    public Campus findCampusByName(String campusName) {
        try {
            Campus campus = em.find(Campus.class, campusName);
            return campus;
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Campus> findAllCampuses() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM campus");
            return  q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteCampus(int campusId){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Campus campus = em.find(Campus.class, campusId);
                em.remove(campus);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}