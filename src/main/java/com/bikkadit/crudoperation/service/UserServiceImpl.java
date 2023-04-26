package com.bikkadit.crudoperation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.bikkadit.crudoperation.dto.UserDto;
import com.bikkadit.crudoperation.entity.User;
import com.bikkadit.crudoperation.helper.AppConstants;
import com.bikkadit.crudoperation.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

//@service,@component,@repository,@conroller,@restcontroller = to create bean
//@bean =class level

@Service
@Slf4j
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		//Convert userDto to entity(user)
		//ModeMapper - object convert into another object
		
		User user = modelmapper.map(userDto, User.class);
		
		User saveduser = userRepo.save(user);
		
		UserDto userDto2 = modelmapper.map(saveduser, UserDto.class);
		
		return userDto2;
	}

	@Override
	public UserDto getSingleUser(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException(AppConstants.NOT_FOUND +userId));
		
		return modelmapper.map(user,UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {

		List<User> allUsers = userRepo.findAll();
		
List<UserDto> list = allUsers.stream().map((users) -> modelmapper
		.map(users, UserDto.class)).collect(Collectors.toList());

		return list;
	}

	@Override
	public UserDto updateUser(UserDto user, Long userId) {
		User user2 = userRepo.findById(userId)
						.orElseThrow(() -> new RuntimeException(AppConstants.NOT_FOUND +userId));
		
		user2.setUserEmail(user.getUserEmail());
		user2.setUserName(user.getUserName());
		user2.setUserName(user.getUserNumber());
		
		User newUser = userRepo.save(user2);
				
		return modelmapper.map(newUser, UserDto.class);
		
	}

	@Override
	public void deleteUser(Long userId) {
		User user = userRepo.findById(userId)
		.orElseThrow(() -> new RuntimeException(AppConstants.NOT_FOUND +userId));
		
		userRepo.delete(user);
		
	}
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public User createUser(User user) {
			User user2 = this.userRepo.save(user);
		return user2;
	}

	@Override
	public User getSingleUser(Long userId) {
		log.info("Entring DAO call for getting single user with userId {}",userId);
		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException(AppConstants.NOT_FOUND +userId));
		log.info("Completed DAO call for getting single user with userId {}",userId);

		return user;
	}

//	@Override
//	public List<User> getAllUser() {
//		List<User> list = userRepo.findAll();
//		return list;
//	}

	@Override  
	public User updateUser(User user, Long userId) {

		User user2 = userRepo.findById(userId).orElseThrow(() -> new RuntimeException(AppConstants.NOT_FOUND +userId));
		
		user2.setUserEmail(user.getUserEmail());
		user2.setUserName(user.getUserName());
		user2.setUserName(user.getUserNumber());
		
		User newUser = userRepo.save(user2);
						
		return newUser;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}
*/
		
}
