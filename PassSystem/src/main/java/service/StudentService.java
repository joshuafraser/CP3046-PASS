package service;

import pojo.Student;
import utilities.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class StudentService {

    EntityManagerFactory emf;
    EntityManager em;

    public StudentService() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void addStudent(Student student) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                em.persist(student);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public void updateStudent(int studentId, String newStudentFName, String newStudentLName) {
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Student student = em.find(Student.class, studentId);
                student.setStuFname(newStudentFName);
                student.setStuLName(newStudentLName);
                t.commit();
            } finally {
                if (t.isActive()) t.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    public Student findStudentById(int stuId) {
        try {
            Student student = em.find(Student.class, stuId);
            return student;
        } finally {
            em.close();
            emf.close();
        }
    }

    //Fix to use native query does not work as is
    public Student findStudentByName(String studentName) {
        try {
            Student student = em.find(Student.class, studentName);
            return student;
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<Student> findAllStudents() {
        try {
            Query q = em.createNativeQuery("SELECT * FROM student");
            return  q.getResultList();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void deleteStudent(int stuId){
        try {
            EntityTransaction t = em.getTransaction();
            try {
                t.begin();
                Student student = em.find(Student.class, stuId);
                em.remove(student);
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