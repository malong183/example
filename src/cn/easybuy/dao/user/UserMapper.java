package cn.easybuy.dao.user;

import cn.easybuy.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);
    //��ѯ
    User selectByPrimaryKey(Integer id);
}