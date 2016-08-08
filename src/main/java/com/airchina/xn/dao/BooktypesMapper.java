package com.airchina.xn.dao;

import com.airchina.xn.entities.Booktypes;
import java.util.List;

public interface BooktypesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Booktypes record);

    Booktypes selectByPrimaryKey(Integer id);

    List<Booktypes> selectAll();

    int updateByPrimaryKey(Booktypes record);
}