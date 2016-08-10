package com.airchina.xn.dao;

import com.airchina.xn.entities.UserRolesPermissions;
import java.util.List;

public interface UserRolesPermissionsMapper {
    int insert(UserRolesPermissions record);

    List<UserRolesPermissions> selectAll();
    
    List<UserRolesPermissions> selectByUserID(Integer user_id);
    
    List<UserRolesPermissions> selectByUserName(String username);
}