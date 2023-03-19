package com.gl.HibernateOneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HibernateOneToOneUni.config.HibernateConfig;
import com.gl.HibernateOneToOneUni.entity.Address;
import com.gl.HibernateOneToOneUni.entity.Student;

/**
 * Hello world!
 *
 */
public class App {

	private static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public static void main(String[] args) {
		System.out.println("Configuration Loaded...");

		Student student = new Student();
//		student.setStudentName("Pratik");
//
//		Address address = new Address("Bangalore");
//
//		student.setAddress(address);

//		try {
//			System.out.println(insertStudent(student));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			student.setStudentId(3);
//			deleteStudent(student);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static int insertStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(student);
		tx.commit();
		session.close();
		return student.getStudentId();
	}

	public static void deleteStudent(Student student) {
		Session session = sessionFactory.openSession();
		student = session.get(Student.class, student.getStudentId());
		Transaction tx = session.beginTransaction();
		session.remove(student);
		tx.commit();
		session.close();
	}
}
