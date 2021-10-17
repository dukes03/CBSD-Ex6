
package studentdatabasejpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class studentDatabaseJPA {

 
    public static void main(String[] args) {
       student emp1 = new student(1, "ma", 3);
       student emp2 = new student(2, "tin", 2);
       studentTable.insertstudent(emp1);
       studentTable.insertstudent(emp2);
       List<student> empList = studentTable.findAllstudent();
       printAllstudent(empList);
    }
    public static void printAllstudent(List<student> studentList) {
        for(student emp : studentList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getgpa() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}