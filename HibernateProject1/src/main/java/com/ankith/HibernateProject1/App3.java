package com.ankith.HibernateProject1;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ankith.HibernateProject1.entity.Course;
import com.ankith.HibernateProject1.entity.Student;
import com.ankith.HibernateProject1.repository.CourseRepository;

public class App3 
{
	public static void main(String[] args) 
	{
		Student s=new Student("Legin",Date.valueOf(LocalDate.of(1998, 2, 1)));
		Student s1=new Student("Wade",Date.valueOf(LocalDate.of(1999, 2, 1)));
		Student s2=new Student("Samber",Date.valueOf(LocalDate.of(1986, 2, 1)));
		Student s3=new Student("Sammer",Date.valueOf(LocalDate.of(1947, 8, 14)));
		
		List<Student> list1=new ArrayList<>();
		list1.add(s);
		list1.add(s1);
		list1.add(s2);
		list1.add(s3);
		
		Course c=new Course("J2EE",25);
		Course c1=new Course("Hibernate",23);
		Course c2=new Course("JDBC",22);
		
		c.setStudents(list1);
		c1.setStudents(list1);
		c2.setStudents(list1);
		
		List<Course> list2=new ArrayList<>();
		list2.add(c);
		list2.add(c1);
		list2.add(c2);
		s.setCourses(list2);
		s1.setCourses(list2);
		s2.setCourses(list2);
		s3.setCourses(list2);
		
		CourseRepository cr=new CourseRepository();
		cr.saveAllCourse(list2);
		
	}	
}
