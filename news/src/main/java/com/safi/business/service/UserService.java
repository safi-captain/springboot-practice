package com.safi.business.service;

import com.safi.business.dao.PermissionDao;
import com.safi.business.dao.RoleDao;
import com.safi.business.dao.UserDao;
import com.safi.business.model.Role;
import com.safi.business.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by xiefeng
 * Time 2018/9/26
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    public int countUser() {
        return userDao.countUser();
    }

    public UserInfo getUserInfoByLoginAccount(String loginAccount) {
        List<UserInfo> userInfoList = userDao.getUserInfoByAccount(loginAccount);
        if (CollectionUtils.isEmpty(userInfoList)) {
            return null;
        }
        UserInfo result = userInfoList.get(0);
        Long userId = result.getUserId();
        result.setRoles(roleDao.getRoleByUserId(userId));
        result.setPerms(permissionDao.getPermissionByUserId(userId));

        return result;
    }
}
