package service;

import pojo.Campus;
import pojo.Result;
import utilities.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Stuart on 29/03/2015.
 */
public class ResultService {

    EntityManagerFactory emf;
    EntityManager em;

    public ResultService() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }


    public void addResult(Result result) {

        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(result);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateResult(int resultId, int newStuId, int newSubId, String newResultGrade, double newResultPercentage) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Result result = em.find(Result.class, resultId);
                result.setStuId(newStuId);
                result.setSubId(newSubId);
                result.setResultGrade(newResultGrade);
                result.setResultPercentage(newResultPercentage);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }


    }

    public Result findResultById(int resultId) {
        try {
            Result result = em.find(Result.class, resultId);

            return result;
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Result> findAllResults() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM result");


            return  q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteResult(int resultId){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Result result = em.find(Result.class, resultId);
                em.remove(result);
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
