
  package com.app.daos;
  


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; import
  org.springframework.transaction.annotation.Transactional;

import com.app.pojos.FarmerAdv;
import com.app.pojos.UserDetails;
import com.app.pojos.WholesalerOrder;
import com.app.pojos.farmerAdvStatus;
  
  @Repository
  
  @Transactional public class WholesalerDaoImpl implements IWholesalerDao {

	  @Autowired
	  private SessionFactory sf;
	@Override
	public WholesalerOrder AddNewOrder(WholesalerOrder f, int userId) {
		 System.out.println("inside AddNewOrder()");
		 System.out.println(f.toString());
		  System.out.println(f.getFarmerAdvId());//3
		  System.out.println(userId);
		  UserDetails userdetails=sf.getCurrentSession().get(UserDetails.class, userId);
		  System.out.println(userdetails);	
		  
		  FarmerAdv farmerAdv=sf.getCurrentSession().get(FarmerAdv.class, f.getFarmerAdvId());
		  int qty=(farmerAdv.getQtyToSale()-f.getOrderQty());
		  int advID=f.getFarmerAdvId();
		  userdetails.addOrder(f);
		  sf.getCurrentSession().saveOrUpdate(userdetails);//update 
		  System.out.println(qty+" "+advID);
		  UserDetails user=farmerAdv.getUserDetails();
		  farmerAdv.setQtyToSale(qty);

			 if(qty==0)
			  {
				  farmerAdv.setAdvStatus(farmerAdvStatus.CLOSED);
			  }
			 user.addFarmerReq(farmerAdv);
	return null;
	}
	
	 public List<WholesalerOrder> showHistoryList(int userId)
	  {
		  System.out.println("inside showHistoryList()"); 
		  System.out.println(userId);
		  UserDetails userDetails=sf.getCurrentSession().get(UserDetails.class, userId);
		  String jpql =  "select c from WholesalerOrder c where  c.userDetails=:id"; 
		  return  sf.getCurrentSession().createQuery(jpql, WholesalerOrder.class).setParameter("id", userDetails).getResultList(); 
	  }
	 public List<WholesalerOrder> showAllHistoryList()
	  {
		  System.out.println("inside showAllHistoryList()"); 
		  //System.out.println(userId);
		  //UserDetails userDetails=sf.getCurrentSession().get(UserDetails.class, userId);
		  String jpql =  "select c from WholesalerOrder c "; 
		  return  sf.getCurrentSession().createQuery(jpql, WholesalerOrder.class).getResultList(); 
	  }
  
  }
  

 