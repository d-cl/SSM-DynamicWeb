package com.offcn.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.offcn.ssm.bean.User;
import com.offcn.ssm.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	public Integer addUser(User user){
		return userMapper.addUser(user);
	}
	
	@Transactional
	public Integer delUserById(Integer id){
		return userMapper.delUserById(id);
	}
	
	@Transactional
	public Integer updateUser(User user){
		return userMapper.updateUser(user);
	}
	
	@Transactional(readOnly=true)
	public List<User> findUser(){
		return userMapper.findUser();
	}
	
	@Transactional(readOnly=true)
	public User findUserById(Integer id){
		return userMapper.findUserById(id);
	}
}
