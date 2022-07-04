package org.sovan.manyApp;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class Dao 
{
public static void main(String[] args)
{
	Configuration conf=new Configuration();
	conf.configure();
	SessionFactory sef=conf.buildSessionFactory();
	Session ses=sef.openSession();
	Transaction tran=ses.beginTransaction();
	
	Course c1=new Course();
	c1.setCourse_name("Java");
	
	Course c2=new Course();
	c2.setCourse_name("Sql");
	
	Student s1=new Student();
	s1.setStudent_name("Sovan");;
	
    Student s2=new Student();
	s2.setStudent_name("Raj");
	
	List<Course> course=new ArrayList<Course>();
	course.add(c1);
	course.add(c2);
	
	List<Student> student=new ArrayList<Student>();
	student.add(s1);
	student.add(s2);
	
	s1.setCourse(course);
	s2.setCourse(course);
	
	ses.save(s1);
	ses.save(s2);
	tran.commit();
	ses.close();
}
}
