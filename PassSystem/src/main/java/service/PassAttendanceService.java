package service;

import pojo.PassAttendance;
import utilities.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Stuart on 29/03/2015.
 */
public class PassAttendanceService {

    EntityManagerFactory emf;
    EntityManager em;

    public PassAttendanceService() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }


    public void addPassAttendance(PassAttendance passAttendance) {

        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(passAttendance);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updatePassAttendance(int attendId, int newStuId, int newSessionId, boolean newAttendStatus) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                PassAttendance passAttendance = em.find(PassAttendance.class, attendId);
                passAttendance.setStuId(newStuId);
                passAttendance.setSessionId(newSessionId);
                passAttendance.setAttendStatus(newAttendStatus);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }


    }

    public PassAttendance findPassAttendanceId(int attendId) {
        try {
            PassAttendance passAttendance = em.find(PassAttendance.class, attendId);

            return passAttendance;
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<PassAttendance> findAllPassAttendances() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM passattendance");


            return  q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deletePassAttendance(int attendId){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                PassAttendance passAttendance = em.find(PassAttendance.class, attendId);
                em.remove(passAttendance);
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
