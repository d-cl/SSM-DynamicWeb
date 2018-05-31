package com.offcn.ssm.mapper;

import java.util.List;

import com.offcn.ssm.bean.User;

public interface UserMapper {

	public Integer addUser(User user);
	
	public Integer delUserById(Integer id);
	
	public Integer updateUser(User user);
	
	public List<User> findUser();
	
	public User findUserById(Integer id);
}
