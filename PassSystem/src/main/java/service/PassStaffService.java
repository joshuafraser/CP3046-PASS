package service;

import pojo.PassStaff;
import utilities.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PassStaffService  {

    EntityManagerFactory emf;
    EntityManager em;

    public PassStaffService() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void addPassStaff(PassStaff passStaff) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(passStaff);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updatePassStaff(int staffId, String staffFName, String staffLName) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                PassStaff passStaff = em.find(PassStaff.class, staffId);
                passStaff.setStaffFName(staffFName);
                passStaff.setStaffLName(staffLName);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public PassStaff findPassStaffById(int passStaffId) {
        try {
            PassStaff passStaff = em.find(PassStaff.class, passStaffId);
            return passStaff;
        } finally {
            em.close();
            emf.close();
        }
    }

    //Fix to use native query does not work as is
    public PassStaff findPassStaffByName(String staffLName) {
        try {
           PassStaff passStaff = em.find(PassStaff.class, staffLName);
            return passStaff;
        } finally {
            em.close();
            emf.close();
        }
    }


    public List<PassStaff> findAllPassStaff() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM passstaff");
            return  q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deletePassStaff(int passStaffId){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                PassStaff passStaff = em.find(PassStaff.class, passStaffId);
                em.remove(passStaff);
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