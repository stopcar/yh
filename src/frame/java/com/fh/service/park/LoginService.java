package com.fh.service.park;

import java.util.List;
import com.fh.dao.DaoSupport;
import com.fh.entity.park.UserInfo;
import com.fh.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 身份认证相关Service
 */
@Service("loginService")
public class LoginService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    // 通过用户ID取用户信息表的数据 pd
    public PageData getUserInfoById(PageData pd)throws Exception{
        return (PageData) dao.findForObject("UserInfoMapper.getUserInfoById",pd);
    }

    // 通过用户名取用户信息表的数据 list
    public List<UserInfo> getUserInfolistById(String userName)throws Exception{
        return (List<UserInfo>) dao.findForList("UserInfoMapper.getUserInfolistById", userName);
    }


}
