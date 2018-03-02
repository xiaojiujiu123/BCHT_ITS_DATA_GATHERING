package com.bcht.its.webservice;


import com.bcht.its.webservice.pojo.User;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by taosh on 2017/4/11.
 */
@WebService
public interface UserManager {
    @WebMethod
    User findUser();
}
