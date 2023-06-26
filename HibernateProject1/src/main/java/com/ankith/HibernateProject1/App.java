package com.ankith.HibernateProject1;

import java.util.*;

import com.ankith.HibernateProject1.entity.BankAccount;
import com.ankith.HibernateProject1.entity.Customer;
import com.ankith.HibernateProject1.entity.OrderData;
import com.ankith.HibernateProject1.entity.Person;
import com.ankith.HibernateProject1.repository.CustomerRepository;
import com.ankith.HibernateProject1.repository.PersonRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Person person=new Person(7,"Manoj k",22,"Male","93515443369");
//        PersonRepository p=new PersonRepository();
//        
//        OrderData od=new OrderData("US pole",4,"shoes");
//        person.setOrderData(od);
//        od.setPerson(person);
//        System.out.println(p.savePerson(person));
    	
    	List<BankAccount> list=new ArrayList<>();
    	list.add(new BankAccount("Canara","512045"));
    	list.add(new BankAccount("SBI","9453612"));
    	list.add(new BankAccount("ICICI","123456"));
    	list.add(new BankAccount("KOTAK","3456712"));
    	list.add(new BankAccount("AXIS","9087654"));
    	list.add(new BankAccount("KARNATAKA BANK","3410011"));
    	list.add(new BankAccount("BANK OF BARODA","1299033"));
    	
    	Customer c=new Customer("Ankith","Shimoga",list);
    	CustomerRepository cr=new CustomerRepository();
    	cr.saveCustomer(c);
//    	String customerById = cr.deleteCustomerById(1);
//    	List<BankAccount> accounts = customerById.getAccounts();
//    	accounts.forEach(System.out::println);
    }
}
