package com.safi.config.shiroComponent;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safi.utils.RedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by xiefeng
 * Time 2018/12/3
 */
@Repository
public class ShiroRedisSessionDao extends EnterpriseCacheSessionDAO {

    @Autowired
    RedisUtil redisUtil;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        System.out.println("--------------------------- 创建session sessionId: " + sessionId);

        redisUtil.set("shiro_session_" + sessionId.toString(), session, 30 * 60);

        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        System.out.println("----------------------------- 读取session sessionId:" + sessionId);
        Session session = super.doReadSession(sessionId);

        if (session == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            session = (Session) redisUtil.get("shiro_session_" + sessionId.toString());
        }

        return session;
    }

    @Override
    protected void doUpdate(Session session) {
        System.out.println("----------------------------- 更新session session:" + session);
        super.doUpdate(session);

        redisUtil.set("shiro_session_" + session.getId().toString(), session, 30 * 60);
    }

    @Override
    protected void doDelete(Session session) {
        System.out.println("----------------------------- 删除session");
        redisUtil.del("shiro_session_" + session.getId().toString());
        super.doDelete(session);
    }
}
