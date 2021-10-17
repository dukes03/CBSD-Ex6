package studentdatabasejpa;

import studentdatabasejpa.student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class studentTable {
        
    public static void insertstudent(student stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(stu);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updatestudent(student stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        student fromDb = em.find(student.class, stu.getId());
        fromDb.setName(stu.getName());
        fromDb.setgpa(stu.getgpa());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static student findstudentById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        student stu = em.find(student.class, id);
        em.close();
        return stu;
    }
    public static List<student> findAllstudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        List<student> stuList = (List<student>) em.createNamedQuery("student.findAll").getResultList();
        em.close();
        return stuList;
    }
    public static List<student> findstudentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("student.findByName");
        query.setParameter("name", name);
        List<student> stuList = (List<student>) query.getResultList();
        em.close();
        return stuList;
    }
    public static void removestudent(student stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        student fromDb = em.find(student.class, stu.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
    
    
    
}