package student_servlet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import student_servlet.dto.Student;

public class StudentDao {
	EntityManager em = Persistence.createEntityManagerFactory("sanju").createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Student saveStudent(Student student) {
		et.begin();
		em.persist(student);
		et.commit();
		return student;		
	}
	
	public Student fetch(String email) throws Exception {
		Query query = em.createQuery("select a from Student a where a.email=?1");
		query.setParameter(1, email);
		return (Student) query.getSingleResult();
	}
	
	public List<Student>fetchAll(){
		Query query = em.createQuery("select a from Student a");
		return query.getResultList();
		
	}

}
