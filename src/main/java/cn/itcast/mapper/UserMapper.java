package cn.itcast.mapper;

import cn.itcast.entity.User;

public interface UserMapper extends SqlMapper {
	
	public User findUserById(Integer id);

	public void createUser(User user);
	
}
