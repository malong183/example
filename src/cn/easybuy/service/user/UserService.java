package cn.easybuy.service.user;

import org.apache.ibatis.annotations.Param;

import cn.easybuy.pojo.User;

public interface UserService {
	
	/**
	 * 获取登录用户
	 * @param loginName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	 User getLoginUser(@Param("loginName")String loginName,@Param("password")String password) throws Exception;
}
