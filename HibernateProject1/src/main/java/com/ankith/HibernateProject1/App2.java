package com.ankith.HibernateProject1;

import java.util.ArrayList;
import java.util.List;

import com.ankith.HibernateProject1.entity.College;
import com.ankith.HibernateProject1.entity.Dept;
import com.ankith.HibernateProject1.repository.CollegeRepository;

public class App2 {

	public static void main(String[] args) 
	{
		College c=new College("IEIT","577226");
		List<Dept> l=new ArrayList<>();
		l.add(new Dept("MECH","CP",c));
		l.add(new Dept("CSE","Ankith",c));
		l.add(new Dept("ECE","Arun",c));
		l.add(new Dept("BCA","Manoj",c));
		l.add(new Dept("EEE","Mayur",c));
		l.add(new Dept("CE","Kashi",c));
		
		c.setDept(l);
		CollegeRepository cr=new CollegeRepository();
//		System.out.println(cr.saveCollege(c));
		
		
		College collegeById = cr.getCollegeById(1);
		List<Dept> dept = collegeById.getDept();
		for(Dept lis:dept)
		{
			System.out.println(lis.getCollege());
		}
		
		

	}

}
