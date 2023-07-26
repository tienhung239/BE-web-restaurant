package com.intern.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.intern.restaurant.dto.UserDTO;
import com.intern.restaurant.dto.UserUpdateDTO;
import com.intern.restaurant.model.User;

@Service
public interface UserService {
	public User createUser(User user);
	public List<UserDTO> getAllUser();
	public UserDTO getUserById(int id);
	public UserDTO getUserByMobile(String mobile);
	public UserDTO getUserByEmail(String email);
	public User updateUser(User user,UserUpdateDTO userUpdateDto);
	public User updateUserPassword(User user, String newPassword);
	public void deleteUser(int id);
}
