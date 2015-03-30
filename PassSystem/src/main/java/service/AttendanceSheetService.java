package service;

import pojo.AttendanceSheet;
import pojo.Campus;
import utilities.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Stuart on 29/03/2015.
 */
public class AttendanceSheetService {
    EntityManagerFactory emf;
    EntityManager em;

    public AttendanceSheetService() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }


    public void addAttendanceSheet(AttendanceSheet attendanceSheet) {

        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(attendanceSheet);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateAttendanceSheet(int attendanceSheetId, int newSessionId, boolean sheetRecorded) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                AttendanceSheet attendanceSheet = em.find(AttendanceSheet.class, attendanceSheetId);
                attendanceSheet.setSessionId(newSessionId);
                attendanceSheet.setSheetRecorded(sheetRecorded);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }


    }

    public AttendanceSheet findAttendanceSheetById(int attendanceSheetId) {
        try {
            AttendanceSheet attendanceSheet = em.find(AttendanceSheet.class, attendanceSheetId);

            return attendanceSheet;
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Campus> findAllAttendanceSheets() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM attendancesheet");


            return  q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteAttendanceSheet(int attendanceSheetId){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                AttendanceSheet attendanceSheet = em.find(AttendanceSheet.class, attendanceSheetId);
                em.remove(attendanceSheet);
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
