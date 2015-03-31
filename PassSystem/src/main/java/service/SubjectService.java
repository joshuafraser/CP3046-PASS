package service;

import pojo.Subject;
import utilities.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class SubjectService {

    EntityManagerFactory emf;
    EntityManager em;

    public SubjectService() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();

    }

    public void addSubject(Subject subject){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(subject);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateSubject(int subjectId, int newSemesterId, String newSubjectCode, String newSubjectName){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Subject subject = em.find(Subject.class, subjectId);
                subject.setSemesterId(newSemesterId);
                subject.setSubCode(newSubjectCode);
                subject.setSubName(newSubjectName);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public Subject findSubjectById(int subjectId){
        try {
           Subject subject = em.find(Subject.class, subjectId);

            return subject;
        } finally {
            em.close();
            emf.close();
        }
    }

    //Fix to use Native query does not work as is requires pk as the identifier.
    public Subject findSubjectByCode(int subjectCode){
        try {
            Subject subject = em.find(Subject.class, subjectCode);

            return subject;
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Subject> findAllSubjects(){
        try {
            Query q = em.createNativeQuery("SELECT * FROM subject");


            return  q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteSubject(int subjectId){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Subject subject = em.find(Subject.class, subjectId);
                em.remove(subject);
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