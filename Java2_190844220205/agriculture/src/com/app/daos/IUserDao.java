package com.app.daos;

import java.util.List;

import com.app.pojos.FarmerAdv;
import com.app.pojos.UserDetails;

public interface IUserDao {
	UserDetails validateUser(String email, String password);
	UserDetails regisrtation(UserDetails u);
	List<FarmerAdv> showAllPendingCropList();
	List<FarmerAdv> showAllLiveCropList();
	List<FarmerAdv> showAllClosedCropList();
	FarmerAdv approvePending(FarmerAdv c) ;
	 UserDetails profile(int userId);
	 UserDetails updateProfile(UserDetails u);
	 List<UserDetails> userList() ;
	 UserDetails changeUserStatus(UserDetails u) ;
}
