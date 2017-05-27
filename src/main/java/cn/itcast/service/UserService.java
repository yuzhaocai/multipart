package cn.itcast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.entity.User;
import cn.itcast.mapper.UserMapper;
import cn.itcast.multipart.DataSource;
import cn.itcast.multipart.DataSourceTypes;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@DataSource(value=DataSourceTypes.MASTER)
	public void createUser(User user){
		userMapper.createUser(user);
	}
	
	@DataSource(value=DataSourceTypes.MASTER)
	@Transactional(readOnly=false)
	public User findUserById(Integer id){
		return userMapper.findUserById(id);
	}

}
