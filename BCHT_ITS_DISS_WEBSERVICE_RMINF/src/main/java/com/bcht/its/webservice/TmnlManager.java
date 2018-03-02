package com.bcht.its.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by taosh on 2017/4/11.
 */
@WebService
public interface TmnlManager {
    @WebMethod
    String findTmnl();
}
