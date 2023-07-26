package com.intern.restaurant.mapper;

import java.util.Optional;

import com.intern.restaurant.dto.UserDTO;
import com.intern.restaurant.model.User;

public class UserMapper {
	public static UserDTO toUserDTO(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setUsername(user.getUsername());
		userDto.setFullname(user.getFullname());
		userDto.setAddress(user.getAddress());
		userDto.setMobile(user.getMobile());
		userDto.setEmail(user.getEmail());
		
		return userDto;
	}
	
	public static UserDTO toUserDTO(Optional<User> user) {
		UserDTO userDto = new UserDTO();
		userDto.setUsername(user.get().getUsername());
		userDto.setFullname(user.get().getFullname());
		userDto.setAddress(user.get().getAddress());
		userDto.setMobile(user.get().getMobile());
		userDto.setEmail(user.get().getEmail());
		
		return userDto;
	}
}
