package service;

import pojo.Semester;
import utilities.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class SemesterService {

    EntityManagerFactory emf;
    EntityManager em;

    public SemesterService() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void addSemester(Semester semester) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(semester);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateSemester(int semesterId, int newCampusId, String newSemesterName) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Semester semester = em.find(Semester.class, semesterId);
                semester.setCampusId(newCampusId);
                semester.setSemesterName(newSemesterName);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public Semester findSemesterById(int semesterId) {
        try {
            Semester semester = em.find(Semester.class, semesterId);
            return semester;
        } finally {
            em.close();
            emf.close();
        }
    }

    //Fix to use native query does not work as is
    public Semester findSemesterByName(String semesterName) {
        try {
            Semester semester = em.find(Semester.class, semesterName);
            return semester;
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Semester> findAllSemesters() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM semester");
            return  q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteSemester(int semesterId){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Semester semester = em.find(Semester.class, semesterId);
                em.remove(semester);
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