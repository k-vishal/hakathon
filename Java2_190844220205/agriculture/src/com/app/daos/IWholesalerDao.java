package com.app.daos;

import java.util.List;

import com.app.pojos.WholesalerOrder;

public interface IWholesalerDao {
	WholesalerOrder AddNewOrder(WholesalerOrder f, int userId);
	List<WholesalerOrder> showHistoryList(int userId) ;
	List<WholesalerOrder> showAllHistoryList() ;
}
