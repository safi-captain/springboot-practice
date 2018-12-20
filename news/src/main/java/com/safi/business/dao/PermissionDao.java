package com.safi.business.dao;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiefeng
 * Time 2018/9/26
 */
@Service
public interface PermissionDao {
    List<String> getPermissionByUserId(Long userId);
}
