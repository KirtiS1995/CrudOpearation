package com.bikkadit.crudoperation.service;

import java.util.List;

import com.bikkadit.crudoperation.dto.UserDto;
import com.bikkadit.crudoperation.entity.User;


public interface UserServiceI {
	
//	User createUser(User user);
//	
//	User getSingleUser(Long userId);
//	
//	List<User> getAllUser();
//	
//	User updateUser(User user,Long userId);
//	
//	void deleteUser(Long userId);
	
	UserDto createUser(UserDto userDto);
	
	UserDto getSingleUser(Long userId);
	
	List<UserDto> getAllUser();
	
	UserDto updateUser(UserDto userDto,Long userId);
	
	void deleteUser(Long userId);
}
