package service;

import pojo.Campus;
import pojo.Week;
import utilities.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Stuart on 29/03/2015.
 */
public class WeekService {

    EntityManagerFactory emf;
    EntityManager em;

    public WeekService() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }


    public void addWeek(Week week) {

        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(week);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateWeek(int weekId, int newSemesterId, String newWeekName) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Week week = em.find(Week.class, weekId);
                week.setSemesterId(newSemesterId);
                week.setWeekName(newWeekName);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }


    }

    public Week findWeekById(int weekId) {
        try {
            Week week = em.find(Week.class, weekId);

            return week;
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
