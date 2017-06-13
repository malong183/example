package cn.easybuy.dao.user;

import cn.easybuy.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);
    //查询单个
    User selectByPrimaryKey(Integer id);
}