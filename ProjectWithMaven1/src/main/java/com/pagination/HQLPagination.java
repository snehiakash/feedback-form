package com.pagination;

import org.hibernate.query.*;

import com.tut.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPagination {
public static void main(String[] args) {
	SessionFactory factory= new Configuration().configure().buildSessionFactory();
	Session s=factory.openSession();
	Query query=s.createQuery("from Student");
	
	//Implementing Pagination using Hibernate
	
	query.setFirstResult(0);
	query.setMaxResults(5);
	List<Student> list=query.list();
	for(Student st:list) {
		System.out.println(st.getId()+" : "+st.getName()+" : ");
	}
	
	
	s.close();
	factory.close(); 
}
}
