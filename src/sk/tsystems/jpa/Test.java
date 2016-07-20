package sk.tsystems.jpa;

import javax.persistence.Query;
import javax.persistence.EntityManager;

public class Test {

	public static void main(String[] args) throws Exception {

		Student student = new Student();
		student.setMeno("Ferko");
		student.setPriezvisko("Hrasko");
		student.setVek(18);

		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(student);
		JpaHelper.commitTransaction();

		Query query = em
				.createQuery("SELECT s FROM Student s WHERE s.meno=:meno");
		query.setParameter("meno", "Ferko");
		System.out.println(query.getResultList());

		JpaHelper.beginTransaction();
		student = em.find(Student.class, 5);
		student.setVek(20); 
//		em.remove(student);
		JpaHelper.commitTransaction();
		System.out.println(student);
		JpaHelper.closeAll();

	}

}
