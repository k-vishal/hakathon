
  package com.app.daos;
  
 import java.util.List;

import org.hibernate.SessionFactory;
 import  org.springframework.beans.factory.annotation.Autowired;
 import  org.springframework.stereotype.Repository;

import com.app.pojos.FarmerAdv;
import com.app.pojos.Role;
import com.app.pojos.UserDetails;
import com.app.pojos.UserStatus;
import com.app.pojos.farmerAdvStatus;
  
  @Repository

  public class UserDaoImpl implements IUserDao 
  {
  
  @Autowired 
  private SessionFactory sf;
  
  @Override 
  public UserDetails validateUser(String email, String password) 
	  {
	  System.out.println("inside userdaoimpl validateuser()");
	  String jpql =  "select u from UserDetails u where u.email=:em and u.password =:pass"; 
	  UserDetails u=  sf.getCurrentSession().createQuery(jpql, UserDetails.class).setParameter("em", email).setParameter("pass",  password).getSingleResult();
	  System.out.println("you are "+u);
	  return u;
	  }
  public UserDetails regisrtation(UserDetails u)
  {
	  System.out.println("inside userdaoimpl registration ()");
	  System.out.println(u);
	  sf.getCurrentSession().persist(u);
	  return u;
  }
  public UserDetails updateProfile(UserDetails u)
  {
	  System.out.println("inside userdaoimpl updateProfile ()");
	  System.out.println(u);
	  sf.getCurrentSession().update(u);
	  return u;
  }
  public List<FarmerAdv> showAllPendingCropList()
  {
	  System.out.println("inside showAllPendingCropList()"); 
	  String jpql =  "select c from FarmerAdv c where c.advStatus=:Status"; 
	  return  sf.getCurrentSession().createQuery(jpql, FarmerAdv.class).setParameter("Status", farmerAdvStatus.PENDING).getResultList(); 
  }
  public FarmerAdv approvePending(FarmerAdv c) {
		System.out.println("inside approvePending()");
		  System.out.println(c);
		  sf.getCurrentSession().saveOrUpdate(c);
		  return c;	
	}  
  public List<FarmerAdv> showAllLiveCropList()
  {
	  System.out.println("inside showAllLiveCropList()"); 
	  String jpql =  "select c from FarmerAdv c where c.advStatus=:Status"; 
	  return  sf.getCurrentSession().createQuery(jpql, FarmerAdv.class).setParameter("Status", farmerAdvStatus.APPROVED).getResultList(); 
  }
  public List<FarmerAdv> showAllClosedCropList()
  {
	  System.out.println("inside showAllClosedCropList()"); 
	  String jpql =  "select c from FarmerAdv c where c.advStatus=:Status"; 
	  return  sf.getCurrentSession().createQuery(jpql, FarmerAdv.class).setParameter("Status", farmerAdvStatus.CLOSED).getResultList(); 
  }
  public UserDetails profile(int userId)
  {
	  System.out.println("inside  profile()");
	  String jpql =  "select u from UserDetails u where u.userId=:id"; 
	  return  sf.getCurrentSession().createQuery(jpql, UserDetails.class).setParameter("id",  userId).getSingleResult();
	    
  }
  public List<UserDetails> userList() 
  {
	  System.out.println("inside  userList()");
	  String jpql =  "select u from UserDetails u where u.userRole=:role1 OR u.userRole=:role2 OR u.userRole=:role3"; 
	  return  sf.getCurrentSession().createQuery(jpql, UserDetails.class).setParameter("role1",Role.FARMER).setParameter("role2",Role.WHOLESALER).setParameter("role3",Role.CPF).getResultList();
	    
  }
  public UserDetails changeUserStatus(UserDetails u)
  {
	  System.out.println("inside userdaoimpl changeUserStatus ()");
	  System.out.println(u.getStatus());
	  if(u.getStatus().equals("ACTIVE"))
	  {
		  u.setStatus("BLOCKED");
	  }
	  else
	  {
		  u.setStatus("ACTIVE");
	  }
	  
	  sf.getCurrentSession().update(u);
	  System.out.println(u.getStatus());
	  return u;
  }
  }
 