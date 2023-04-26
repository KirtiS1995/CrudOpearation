package com.bikkadit.crudoperation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.crudoperation.dto.UserDto;
import com.bikkadit.crudoperation.entity.User;
import com.bikkadit.crudoperation.helper.AppConstants;
import com.bikkadit.crudoperation.service.UserServiceI;


@RestController				//Controller + response body
@RequestMapping("/api")			//base URL
public class UserController {

	@Autowired
	private UserServiceI userServiceI;
	
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	
	/**
	 * @author kirti
	 * @since v1.0
	 * @apiNote This method is  for create user
	 * @param user
	 * @return
	 */
	
	@PostMapping("/users")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		UserDto createUser = userServiceI.createUser(userDto);
		return new ResponseEntity<UserDto> (createUser,HttpStatus.CREATED) ;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> allUser = userServiceI.getAllUser();
				return new ResponseEntity<List<UserDto>>(allUser, HttpStatus.OK);
		}
	
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Long userId){
		UserDto singleUser = userServiceI.getSingleUser(userId);
				return new ResponseEntity<UserDto>(singleUser, HttpStatus.OK);
		}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user,@PathVariable Long userId){
		UserDto updateUser = userServiceI.updateUser(user, userId);
				return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);
		}	
	

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId){
		 userServiceI.deleteUser(userId);
		 return new ResponseEntity<String>(AppConstants.USER_DELETE,HttpStatus.OK);
	}			
	
	/*
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		logger.info("Request entring for create user");
		User createUser = this.userServiceI.createUser(user);
		logger.info("Completed Request for create user");

				return new ResponseEntity<User>(createUser, HttpStatus.CREATED);
		}*/
	
	/**
	 * @author kirti
	 * @apiNote This method is for get all users
	 * @
	 * @return
*/
	/*
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userServiceI.getAllUser();
				return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
		}
	
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable Long userId){
		logger.info("Request entring for getting single user with userId : {}",userId);
		User singleUser = userServiceI.getSingleUser(userId);
		logger.info("Request completed for getting single user with userId :{}",userId);

				return new ResponseEntity<User>(singleUser, HttpStatus.OK);
		}
	
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userId){
	 User updateUser = userServiceI.updateUser(user, userId);
				return new ResponseEntity<User>(updateUser, HttpStatus.CREATED);
		}	
	

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId){
		 userServiceI.deleteUser(userId);
				return new ResponseEntity<String>(AppConstants.USER_DELETE, HttpStatus.OK);
		}
	*/
	
}
