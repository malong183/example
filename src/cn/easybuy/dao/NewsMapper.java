package cn.easybuy.dao;

import cn.easybuy.pojo.News;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);
}