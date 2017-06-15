package cn.easybuy.service.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.easybuy.dao.user.UserMapper;
import cn.easybuy.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getLoginUser(String loginName, String password)
			throws Exception {
		return userMapper.getLoginUser(loginName, password);	//获取登录用户;
	}

}
