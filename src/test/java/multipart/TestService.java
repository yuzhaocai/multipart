package multipart;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.entity.User;
import cn.itcast.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-core.xml")
public class TestService {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testCreateUser(){
		try {
			User user = new User();
			user.setUsername("handing");
			user.setPassword("123456");
			user.setEmail("870646595@qq.com");
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1990-12-20"));
			//DataSourceContextHolder.setDataSourceType(DataSourceTypes.MASTER);
			userService.createUser(user);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindUserById(){
		//DataSourceContextHolder.setDataSourceType(DataSourceTypes.SLAVE);
		User user = userService.findUserById(1);
		System.out.println(user);
	}
}
