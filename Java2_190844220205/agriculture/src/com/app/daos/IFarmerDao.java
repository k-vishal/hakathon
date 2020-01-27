package com.app.daos;

import java.util.List;

import com.app.pojos.Crop;
import com.app.pojos.FarmerAdv;

public interface IFarmerDao {
	Crop addCrop(Crop c) ;
	Crop deleteCrop(Crop c) ;
	FarmerAdv addNewAdv(FarmerAdv f,int userId);
	List<Crop> showCrop();
	List<FarmerAdv> showPendingCropList(int userId);
	FarmerAdv deletePending(FarmerAdv c);
	List<FarmerAdv> showLiveCropList(int userId);
	List<FarmerAdv> showClosedCropList(int userId);
}
