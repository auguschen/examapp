package com.airchina.xn.dao;

import com.airchina.xn.entities.UserRoles;
import java.util.List;

public interface UserRolesMapper {
    int insert(UserRoles record);

    List<UserRoles> selectAll();
 
    List<UserRoles> selectByUserID(Integer user_id);
    
    List<UserRoles> selectByUserName(String username);
}