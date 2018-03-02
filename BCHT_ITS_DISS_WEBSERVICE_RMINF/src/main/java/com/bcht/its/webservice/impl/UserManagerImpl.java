package com.bcht.its.webservice.impl;


import com.bcht.its.webservice.UserManager;
import com.bcht.its.webservice.pojo.User;

import javax.jws.WebService;


/**
 * Created by taosh on 2017/4/11.
 */
@WebService
public class UserManagerImpl implements UserManager {
    @Override
    public User findUser() {
        User user = new User("陶诗德",12);
        return user;
    }
}
