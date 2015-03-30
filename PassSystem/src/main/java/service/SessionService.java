package service;

import pojo.Campus;
import pojo.Session;
import utilities.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Stuart on 29/03/2015.
 */
public class SessionService {

    EntityManagerFactory emf;
    EntityManager em;

    public SessionService() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }


    public void addSession(Session session) {

        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(session);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateSession(int sessionId, int newSubjectId, int newStaffId, String newSessionName, String newSessionDate, int newWeekId ) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Session session = em.find(Session.class, sessionId);
                session.setSubId(newSubjectId);
                session.setStaffId(newStaffId);
                session.setSessionName(newSessionName);
                session.setSessionDate(newSessionDate);
                session.setWeekId(newWeekId);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }


    }

    public Session findSessionById(int sessionId) {
        try {
            Session session = em.find(Session.class, sessionId);

            return session;
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Session> findAllSessions() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM session");


            return  q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteSession(int sessionId){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Session session = em.find(Session.class, sessionId);
                em.remove(session);
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
