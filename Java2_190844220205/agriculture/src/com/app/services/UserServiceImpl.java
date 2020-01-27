package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.daos.ICpfDao;
import com.app.daos.IFarmerDao;
import com.app.daos.IUserDao;
import com.app.daos.IWholesalerDao;
import com.app.pojos.Course;
import com.app.pojos.Crop;
import com.app.pojos.FarmerAdv;
import com.app.pojos.Role;
import com.app.pojos.UserDetails;
import com.app.pojos.WholesalerOrder;

@Service
@Transactional 
public class UserServiceImpl {
	
	 @Autowired 
	  private IUserDao userDao;
	  
	  @Autowired 
	  private IFarmerDao farmerDao;
	  
	  @Autowired
	  private IWholesalerDao wholesalerDao;
	  @Autowired
	  private ICpfDao cpfDao;
	  
	  public UserDetails validateUser(@RequestBody  UserDetails u)
	  {
	   System.out.println("data rreceived"); 
	  System.out.println(u.toString());
	  UserDetails user =  userDao.validateUser(u.getEmail(), u.getPassword());
	  System.out.println(user.toString());
	  if((user.getUserRole().equals(Role.ADMIN)) || (user.getUserRole().equals(Role.FARMER))||(user.getUserRole().equals(Role.WHOLESALER)) ||
			  (user.getUserRole().equals(Role.CPF)) ) 
	  {
	  System.out.println("inside /login validate"); 
	  return  user;
	  }
	  return null;
	  }
	  
	  public UserDetails regisrtation(UserDetails u)
	  {
		 return userDao.regisrtation(u);
	  }
	  public UserDetails updateProfile(UserDetails u)
	  {
		 return userDao.updateProfile(u);
	  }
	  public List<Crop> showCrop() 
		{
			return farmerDao.showCrop();
		}
	  public List<FarmerAdv> showPendingCropList(int userId) 
		{
			return farmerDao.showPendingCropList(userId);
		}
	  public List<FarmerAdv> showLiveCropList(int userId) 
		{
			return farmerDao.showLiveCropList(userId);
		}
	  public List<FarmerAdv> showClosedCropList(int userId) 
		{
			return farmerDao.showClosedCropList(userId);
		}
	  public List<FarmerAdv> showAllPendingCropList() 
		{
			return userDao.showAllPendingCropList();
		}
	  public List<FarmerAdv> showAllLiveCropList() 
		{
			return userDao.showAllLiveCropList();
		}
	  public List<FarmerAdv> showAllClosedCropList() 
		{
			return userDao.showAllClosedCropList();
		}
	  
	  
	public Crop addCrop(Crop c) 
	{
		return farmerDao.addCrop(c);
	}
	public Crop deleteCrop(Crop c) 
	{
		return farmerDao.deleteCrop(c);
	}
//	public FarmerAdv addNewAdv(FarmerAdv f, int userId)
//	{
//		return farmerDao.addNewAdv(f,userId);
//	}
	public FarmerAdv addNewAdv(FarmerAdv f, int userId)
	{
		return farmerDao.addNewAdv(f,userId);
	}
	public FarmerAdv deletePending(FarmerAdv c) 
	{
		return farmerDao.deletePending(c);
	}
	public FarmerAdv approvePending(FarmerAdv c) 
	{
		return userDao.approvePending(c);
	}
	public WholesalerOrder AddNewOrder(WholesalerOrder f, int userId)
	{
		return wholesalerDao.AddNewOrder(f,userId);
	}
	public List<WholesalerOrder> showHistoryList(int userId) 
	{
		return wholesalerDao.showHistoryList(userId);
	}
	public List<WholesalerOrder> showAllHistoryList() 
	{
		return wholesalerDao.showAllHistoryList();
	}
	public UserDetails profile(int userId) 
	{
		return userDao.profile(userId);
	}
	public List<UserDetails> userList() 
	{
		return userDao.userList();
	}
	public UserDetails changeUserStatus(UserDetails u) 
	{
		return userDao.changeUserStatus(u);
	}
	public Course NewCourse(Course u, int id) 
	{
		return cpfDao.NewCourse(u, id);
	}
	public List<Course> pendingCourseList() 
	{
		return cpfDao.pendingCourseList();
	}
	
	  
	  
	  

}
