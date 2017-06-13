package cn.easybuy.dao.news;

import cn.easybuy.pojo.News;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);
}