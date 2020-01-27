
  package com.app.controllers;
  import java.util.List;
  import javax.annotation.PostConstruct;
  
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import  org.springframework.http.ResponseEntity; 
  import  org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Course;
import com.app.pojos.Crop;
import com.app.pojos.FarmerAdv;
import  com.app.pojos.UserDetails;
import com.app.pojos.WholesalerOrder;
import com.app.services.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

  
  @RestController
  @CrossOrigin
  @RequestMapping("/user")
  public class UserController {
  
	  @Autowired 
	  private UserServiceImpl userService;
	 
  
  @PostConstruct public void myInit() 
  {
  System.out.println("in init of "+getClass().getName()+" dao");
 
  }
  
  @PostMapping("/login")
  public ResponseEntity<?> validateUser(@RequestBody  UserDetails u)
  {
	
	  ResponseEntity<UserDetails> u1= new  ResponseEntity<UserDetails>(userService.validateUser(u), HttpStatus.OK);
	  System.out.println(u1);
	  
	  return u1;
  }
  
  @PostMapping("/register")
  public ResponseEntity<?> registration(@RequestBody  UserDetails u)
  {
	 
	  return new  ResponseEntity<UserDetails>(userService.regisrtation(u), HttpStatus.OK);
  }
  //@GetMapping("/showCrop")
  @RequestMapping(value = "/showCrop", method = RequestMethod.GET)
  public ResponseEntity<?> showCrop()
  {
	  List<Crop> listAllCrop=userService.showCrop();
	  if(listAllCrop.size()!=0)
	  return new  ResponseEntity<List<Crop>>(listAllCrop, HttpStatus.OK);
	  return new ResponseEntity<Void>(HttpStatus.OK);
  }
  @PostMapping("/addCrop")
  public ResponseEntity<?> addCrop(@RequestBody  Crop c)
  {
	  return new  ResponseEntity<Crop>(userService.addCrop(c), HttpStatus.OK);
  }
  @PostMapping("/deleteCrop")
//  @RequestMapping(value = "/deleteCrop", method = RequestMethod.POST)
  public ResponseEntity<?> deleteCrop(@RequestBody  Crop c)
  {
	  return new  ResponseEntity<Crop>(userService.deleteCrop(c), HttpStatus.OK);
  }

//  @PostMapping("/addNewAdv/{userId}")
// public ResponseEntity<?> addNewAdv(@RequestBody  FarmerAdv f,@PathVariable int userId )
//  {
//	  System.out.println("inside new crop adv");
//	  return new  ResponseEntity<FarmerAdv>(userService.addNewAdv(f,userId), HttpStatus.OK);
//  }
  @PostMapping("/addNewAdv/{userId}")
 public ResponseEntity<?> addNewAdv(@RequestParam(value="file") MultipartFile file,@RequestParam(value="user") String u1,@PathVariable int userId )
  {
  System.out.println("in fill adv details : "+u1);
	  try {
	  System.out.println("inside new crop adv");
	  FarmerAdv f=new ObjectMapper().readValue(u1,FarmerAdv.class);
		f.setCropImage(file.getBytes());
	 return new  ResponseEntity<FarmerAdv>(userService.addNewAdv(f,userId), HttpStatus.OK);

////		  FarmerAdv u2=new ObjectMapper().readValue(u1,FarmerAdv.class);
////			u2.setCropImage(file.getBytes());
////			dao.register(u2);
////			return new ResponseEntity<>(HttpStatus.OK);
	  }catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
  }
  @RequestMapping(value = "/showPendingCropList/{userId}", method = RequestMethod.GET)
  public ResponseEntity<?> showPendingCropList(@PathVariable int userId)
  {
	  List<FarmerAdv> listAllCrop=userService.showPendingCropList(userId);
	  if(listAllCrop.size()!=0)
	  return new  ResponseEntity<List<FarmerAdv>>(listAllCrop, HttpStatus.OK);
	  return new ResponseEntity<Void>(HttpStatus.OK);
  }
  @PostMapping("/deletePending")

	public ResponseEntity<?> deletePending(@RequestBody  FarmerAdv c)
	{
		  return new  ResponseEntity<FarmerAdv>(userService.deletePending(c), HttpStatus.OK);
	}
  @RequestMapping(value = "/showLiveCropList/{userId}", method = RequestMethod.GET)
  public ResponseEntity<?> showLiveCropList(@PathVariable int userId)
  {
	  List<FarmerAdv> listAllCrop=userService.showLiveCropList(userId);
	  if(listAllCrop.size()!=0)
	  return new  ResponseEntity<List<FarmerAdv>>(listAllCrop, HttpStatus.OK);
	  return new ResponseEntity<Void>(HttpStatus.OK);
  }
  @RequestMapping(value = "/showClosedCropList/{userId}", method = RequestMethod.GET)
  public ResponseEntity<?> showClosedCropList(@PathVariable int userId)
  {
	  List<FarmerAdv> listAllCrop=userService.showClosedCropList(userId);
	  if(listAllCrop.size()!=0)
	  return new  ResponseEntity<List<FarmerAdv>>(listAllCrop, HttpStatus.OK);
	  return new ResponseEntity<Void>(HttpStatus.OK);
  }
  @RequestMapping(value = "/showAllPendingCropList", method = RequestMethod.GET)
  public ResponseEntity<?> showAllPendingCropList()
  {
	  List<FarmerAdv> listAllCrop=userService.showAllPendingCropList();
	  if(listAllCrop.size()!=0)
	  return new  ResponseEntity<List<FarmerAdv>>(listAllCrop, HttpStatus.OK);
	  return new ResponseEntity<Void>(HttpStatus.OK);
  }
  @PostMapping("/approvePending")
  public ResponseEntity<?> approvePending(@RequestBody  FarmerAdv c)
	{
		  return new  ResponseEntity<FarmerAdv>(userService.approvePending(c), HttpStatus.OK);
	}
  
  @RequestMapping(value = "/showAllLiveCropList", method = RequestMethod.GET)
  public ResponseEntity<?> showAllLiveCropList()
  {
	  List<FarmerAdv> listAllCrop=userService.showAllLiveCropList();
	  if(listAllCrop.size()!=0)
	  return new  ResponseEntity<List<FarmerAdv>>(listAllCrop, HttpStatus.OK);
	  return new ResponseEntity<Void>(HttpStatus.OK);
  }
  @RequestMapping(value = "/showAllClosedCropList", method = RequestMethod.GET)
  public ResponseEntity<?> showAllClosedCropList()
  {
	  List<FarmerAdv> listAllCrop=userService.showAllClosedCropList();
	  if(listAllCrop.size()!=0)
	  return new  ResponseEntity<List<FarmerAdv>>(listAllCrop, HttpStatus.OK);
	  return new ResponseEntity<Void>(HttpStatus.OK);
  }
  @PostMapping("/AddNewOrder/{userId}")
  public ResponseEntity<?> AddNewOrder(@RequestBody  WholesalerOrder f,@PathVariable int userId )
  {
	  System.out.println("inside new wholesaler order");
	  return new  ResponseEntity<WholesalerOrder>(userService.AddNewOrder(f,userId), HttpStatus.OK);
  }
  
  @RequestMapping(value = "/showHistoryList/{userId}", method = RequestMethod.GET)
  public ResponseEntity<?> showHistoryList(@PathVariable int userId)
  {
	  List<WholesalerOrder> listAllCrop=userService.showHistoryList(userId);
	  if(listAllCrop.size()!=0)
	  return new  ResponseEntity<List<WholesalerOrder>>(listAllCrop, HttpStatus.OK);
	  return new ResponseEntity<Void>(HttpStatus.OK);
  }
  @RequestMapping(value = "/showAllHistoryList", method = RequestMethod.GET)
  public ResponseEntity<?> showAllHistoryList()
  {
	  List<WholesalerOrder> listAllCrop=userService.showAllHistoryList();
	  if(listAllCrop.size()!=0)
	  return new  ResponseEntity<List<WholesalerOrder>>(listAllCrop, HttpStatus.OK);
	  return new ResponseEntity<Void>(HttpStatus.OK);
  }
  
  @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
  public ResponseEntity<?> profile(@PathVariable int userId)
  {
	  UserDetails userDetails=userService.profile(userId);	 
	  return new  ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
  }
  @PostMapping("/updateProfile")
  public ResponseEntity<?> updateProfile(@RequestBody  UserDetails u)
  {
	 
	  return new  ResponseEntity<UserDetails>(userService.updateProfile(u), HttpStatus.OK);
  }
 
  @RequestMapping(value = "/userList", method = RequestMethod.GET)
  public ResponseEntity<?> userList()
  {
	  List<UserDetails> userDetails=userService.userList();	 
	  return new  ResponseEntity<List<UserDetails>>(userDetails, HttpStatus.OK);
  }
  @PostMapping("/changeUserStatus")
  public ResponseEntity<?> changeUserStatus(@RequestBody  UserDetails u)
  {
	 
	  return new  ResponseEntity<UserDetails>(userService.changeUserStatus(u), HttpStatus.OK);
  }

  @PostMapping("/NewCourse/{userId}")
  public ResponseEntity<?> NewCourse(@RequestBody  Course c,@PathVariable int userId)
  {
	 System.out.println(c.toString());
	 System.out.println(userId);
	  return new  ResponseEntity<Course>(userService.NewCourse(c,userId), HttpStatus.OK);
  }
  
  @RequestMapping(value = "/pendingCourseList", method = RequestMethod.GET)
  public ResponseEntity<?> pendingCourseList()
  {
	  List<Course> listAllCourse=userService.pendingCourseList();
	  if(listAllCourse.size()!=0)
	  return new  ResponseEntity<List<Course>>(listAllCourse, HttpStatus.OK);
	  return new ResponseEntity<Void>(HttpStatus.OK);
  }
  
  
}
 