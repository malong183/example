package cn.easybuy.dao.user;

import org.apache.ibatis.annotations.Param;

import cn.easybuy.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);
    //查询单个
    User selectByPrimaryKey(Integer id);
    
    /**
     * 获取登录用户
     * @param loginName
     * @param password
     * @return
     */
    User getLoginUser(@Param("loginName")String loginName,@Param("password")String password) throws Exception;
}