package com.spring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
    ApplicationContext  context=new ClassPathXmlApplicationContext("config.xml");
             
    StudentDao studentDao=(StudentDao)context.getBean("studentDao",StudentDao.class);
     
//    Student student=new Student(123,"Raj","Noida");
//    
//    int r=studentDao.insert(student);
//     System.out.println(r);
    
    // BufferedReader is used to take input from user/console
    
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     boolean go=true; 
    while(go)
    {
    System.out.println("PRESS  1  For  Add      New      Student");
    System.out.println("PRESS  2  For  Display  All      Student");
    System.out.println("PRESS  3  For  Get      Details   Of     Single Student");
    System.out.println("PRESS  4  For  Delete   Student");
    System.out.println("PRESS  5  For  Update   Student");
    System.out.println("PRESS  6  For  Exist");
    
    try
    {
     int input=Integer.parseInt(br.readLine());
    
     switch (input)
     {
     case 1:// Add new student
    	    System.out.println("Enter User Id");
    	    int uid=Integer.parseInt(br.readLine());
    	    
    	    System.out.println("Enter User Name");
    	    String uName=br.readLine();
    	    
    	    System.out.println("Enter User City");
    	    String uCity=br.readLine();
    	    
    	    Student s=new Student();
    	    
    	    s.setId(uid);
    	    s.setName(uName);
    	    s.setCity(uCity);
    	    
    	    int r=studentDao.insert(s);
    	    
    	    System.out.println(r+" Student added");
    	    System.out.println("**********************************");
    	    System.out.println();
    	    
    	    break;
    
    	    
     case 2: // Display  All
    	     
    	   System.out.println("************************************");
    	    
    	   List<Student> allStudent = studentDao.getAllStudent();
    	   
    	   for(Student std: allStudent)
    	   {
    		   System.out.println("Id : "+  std.getId());
    		   System.out.println("Name : "+  std.getName());
    		   System.out.println("City : "+  std.getCity());
    		   System.out.println("______________________________");
    		   
    	   }
    	  
   	        break;
   	        
   	        
   	        
     case 3://Gel details of Student
    	     
    	      System.out.println("Enter the user id :");
    	      int userId=Integer.parseInt(br.readLine());
    	      Student student=studentDao.getStudent(userId);
    	      System.out.println("************************************");
    	      System.out.println("Id : "+  student.getId());
   		      System.out.println("Name : "+  student.getName());
   		      System.out.println("City : "+  student.getCity());
   		      System.out.println("______________________________");
    	     	 
   	        break;
     
     case 4://delete
    	     System.out.println("Enter the user id :");
	         int uId=Integer.parseInt(br.readLine());
    	   
	         studentDao.deleteStudent(uId);
	         System.out.println("Student Deleted........");
   	         break;
   	         
     case 5:  // update
    	      Student st=new Student();  
    	     
    	      System.out.println("Enter the user id which data do you want to update ?:");
              int id=Integer.parseInt(br.readLine());
    	    
              System.out.println("Enter User Name");
      	      String name=br.readLine();
      	    
      	      System.out.println("Enter User City");
      	      String city=br.readLine();    
      	   
      	      st.setId(id);
    	      st.setName(name);
    	      st.setCity(city);
    	      
    	      studentDao.updateStudent(st);
    	      System.out.println("Records Updated !!! ");
   	         break;
   	         
   	         
     case 6: // Exit
    	     go=false;
    	     break;
    	 
     }
    	
    }catch(Exception e)
    {
    	System.out.println("Invalid Input Try With anoher one !!!");
    	System.out.println(e.getMessage());
    }
    
   
    } 
     
     
    System.out.println("Thank you for using my Application");
    System.out.println("See you soon !!!");
     
     
     
     
    }
}
