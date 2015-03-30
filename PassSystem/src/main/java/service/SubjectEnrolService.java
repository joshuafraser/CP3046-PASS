package service;

import pojo.Campus;
import pojo.Subject;
import pojo.SubjectEnrol;
import utilities.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Stuart on 29/03/2015.
 */
public class SubjectEnrolService {

    EntityManagerFactory emf;
    EntityManager em;

    public SubjectEnrolService() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }


    public void addSubjectEnrol(SubjectEnrol subjectEnrol) {

        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(subjectEnrol);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public SubjectEnrol findSubjectEnrolById(int enrolId) {
        try {
            SubjectEnrol subjectEnrol = em.find(SubjectEnrol.class, enrolId);

            return subjectEnrol;
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<SubjectEnrol> findAllSubjectEnrol() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM subjectenrol");


            return  q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteSubjectEnrol(int enrolId){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                SubjectEnrol subjectEnrol = em.find(SubjectEnrol.class, enrolId);
                em.remove(subjectEnrol);
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
