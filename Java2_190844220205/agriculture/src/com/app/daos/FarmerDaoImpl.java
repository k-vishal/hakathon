
  package com.app.daos;
  
  import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Crop;
import com.app.pojos.FarmerAdv;
import com.app.pojos.UserDetails;
import com.app.pojos.farmerAdvStatus;

  
  @Repository
  

  public class FarmerDaoImpl implements IFarmerDao{
	  @Autowired
	  private SessionFactory sf;
	  
	  public List<Crop> showCrop()
	  {
		  System.out.println("inside showCrop()"); 
		  String jpql =  "select c from Crop c"; 
		  return  sf.getCurrentSession().createQuery(jpql, Crop.class).getResultList();
		  
		  
	  }
	  
	  public Crop addCrop(Crop c) 
		{
		  System.out.println("inside addcropr()");
		  System.out.println(c);
		  sf.getCurrentSession().persist(c);
		  return c;
		  
		}
	  private boolean deleteById(Class<?> type, Serializable id) {
		    Object persistentInstance = sf.getCurrentSession().load(type, id);
		    if (persistentInstance != null) {
		    	sf.getCurrentSession().delete(persistentInstance);
		        return true;
		    }
		    return false;
		}
	 
	  public Crop deleteCrop(Crop c) 
	  {
		  System.out.println("inside addcropr()");
		  System.out.println(c);
		  boolean res=deleteById(Crop.class, c.getCropId());
		  System.out.println(res);
		  if(res)
		  {
			  return c;
		  }
		  return null;
		  
	  }
	 
	  
	  public FarmerAdv addNewAdv(FarmerAdv f,int userId)
		{
		  System.out.println("inside addNewAdv()");
		 // System.out.println(f.toString());
		  System.out.println(userId);
		  UserDetails userDetails=sf.getCurrentSession().get(UserDetails.class, userId);
		  //userDetails.setparam
		  System.out.println(userDetails);
		  userDetails.addFarmerReq(f);
		  sf.getCurrentSession().update(userDetails);//update 
			return f;
		}
	  public List<FarmerAdv> showPendingCropList(int userId)
	  {
		  System.out.println("inside showPendingCropList()"); 
		  System.out.println(userId);
		  UserDetails userDetails=sf.getCurrentSession().get(UserDetails.class, userId);
		  String jpql =  "select c from FarmerAdv c where c.advStatus=:status and c.userDetails=:id"; 
		  return  sf.getCurrentSession().createQuery(jpql, FarmerAdv.class).setParameter("status", farmerAdvStatus.PENDING).setParameter("id", userDetails).getResultList(); 
	  }
	  public List<FarmerAdv> showLiveCropList(int userId)
	  {
		  System.out.println("inside showLiveCropList()"); 
		  System.out.println(userId);
		  UserDetails userDetails=sf.getCurrentSession().get(UserDetails.class, userId);
		  String jpql =  "select c from FarmerAdv c where c.advStatus=:Status AND c.userDetails=:id"; 
		  return  sf.getCurrentSession().createQuery(jpql, FarmerAdv.class).setParameter("Status", farmerAdvStatus.APPROVED).setParameter("id", userDetails).getResultList(); 
	  }
	  public List<FarmerAdv> showClosedCropList(int userId)
	  {
		  System.out.println("inside showClosedCropList()"); 
		  System.out.println(userId);
		  UserDetails userDetails=sf.getCurrentSession().get(UserDetails.class, userId);
		  String jpql =  "select c from FarmerAdv c where c.advStatus=:Status AND c.userDetails=:id"; 
		  return  sf.getCurrentSession().createQuery(jpql, FarmerAdv.class).setParameter("Status", farmerAdvStatus.CLOSED).setParameter("id", userDetails).getResultList(); 
	  }

	
	public FarmerAdv deletePending(FarmerAdv c) {
		System.out.println("inside deletePending()");
		  System.out.println(c);
		  sf.getCurrentSession().saveOrUpdate(c);
		  return c;	
	}
	  
  
  }
 