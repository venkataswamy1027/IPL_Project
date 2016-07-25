package com.bridgelabz.dao;
import com.bridgelabz.model.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import java.util.List;
@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{
     
			 
       @Resource(name="sessionFactory")
       //creating session factory object  
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }
     //method to save user data
       public void addUser(Users user) {
   		sessionFactory.openSession().save(user);
   	}
       //check user name and password matched or not
       public boolean checkLogin(String userName, String userPassword){
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY =" from Users as o where o.userName=? and o.userPassword=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,userPassword);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}

			session.close();
			return userFound;              
       }
     //check user email matched in existing database or not
       public boolean checkEmail(String email)
       {
    	   Session session1=sessionFactory.openSession();
    	   boolean userFound1=false;
    	   //query 
    	   System.out.println("email is query execuited");
    	   String sql_queri="from Users as o where o.email=?";
    	   Query queri=session1.createQuery(sql_queri);
			queri.setParameter(0,email);
			List list = queri.list();
			if ((list != null) && (list.size() > 0)) 
			{
				userFound1= true;
			}
			session1.close();
			return userFound1;         
      }
     //check user name  matched in existing database or not.
      public boolean checkUserName(String userName)
       {
    	   Session session1=sessionFactory.openSession();
    	   boolean userFound1=false;
    	   //query 
    	   System.out.println("username is query execuited");
    	   String sql_queri="from Users as o where o.userName=?";
    	   Query queri=session1.createQuery(sql_queri);
			queri.setParameter(0,userName);
			List list = queri.list();
			if ((list != null) && (list.size() > 0)) 
			{
				userFound1= true;
			}
			session1.close();
			return userFound1;              
      }
}
