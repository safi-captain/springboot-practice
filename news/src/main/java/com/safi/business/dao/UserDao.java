package com.safi.business.dao;

import com.safi.business.model.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiefeng
 * Time 2018/9/26
 */
@Service
public interface UserDao {
    int countUser();

    List<UserInfo> getUserInfoByAccount(String loginAccount);
}
