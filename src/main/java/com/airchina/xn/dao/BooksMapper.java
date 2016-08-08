package com.airchina.xn.dao;

import com.airchina.xn.entities.Books;
import java.util.List;

public interface BooksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Books record);

    Books selectByPrimaryKey(Integer id);

    List<Books> selectAll();

    int updateByPrimaryKey(Books record);
}