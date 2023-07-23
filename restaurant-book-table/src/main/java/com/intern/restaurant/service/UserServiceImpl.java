package com.intern.restaurant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.restaurant.dto.UserDTO;
import com.intern.restaurant.dto.UserUpdateDTO;
import com.intern.restaurant.exception.UserException;
import com.intern.restaurant.exception.UserNotFoundException;
import com.intern.restaurant.mapper.UserMapper;
import com.intern.restaurant.model.User;
import com.intern.restaurant.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> existing = userRepository.findByMobile(user.getMobile());
		if(existing.isPresent())
			throw new UserException("User already exists");
		userRepository.save(user);
		return user;
	}

	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
		List<UserDTO> userDtos = new ArrayList<>();
		for (User user : userRepository.findAll()) {
			userDtos.add(UserMapper.toUserDTO(user));
		}
		if (userDtos.size() == 0) 
			throw new UserNotFoundException("No record exists");
		return userDtos;
	}
	
	@Override
	public UserDTO getUserById(int id) {
		// TODO Auto-generated method stub
		UserDTO userDto = UserMapper.toUserDTO(userRepository.findById(id).orElse(null));
		return userDto;
	}

	@Override
	public UserDTO getUserByMobile(String mobile) {
		// TODO Auto-generated method stub
		UserDTO userDto = UserMapper.toUserDTO(userRepository.findByMobile(mobile).orElse(null));
		return userDto;
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		// TODO Auto-generated method stub
		UserDTO userDto = UserMapper.toUserDTO(userRepository.findByEmail(email).orElse(null));
		return userDto;
	}
	
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}


	@Override
	public User updateUser(User user,UserUpdateDTO userUpdateDto) {
		// TODO Auto-generated method stub
		user.setPassword(userUpdateDto.getPassword());
		user.setFullname(userUpdateDto.getFullname());
		user.setAddress(userUpdateDto.getAddress());
		user.setMobile(userUpdateDto.getMobile());
		user.setEmail(userUpdateDto.getEmail());
		return userRepository.save(user);
	}

	@Override
	public User updateUserPassword(User user, String newPassword) {
		// TODO Auto-generated method stub
		user.setPassword(newPassword);
		return userRepository.save(user);
		
	}

	

}
