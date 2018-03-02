package com.bcht.its.restful;

/**
 * Created by taosh on 2017/4/28.
 */

import com.bcht.its.commons.beans.TerminalInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.nutz.dao.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备信息管理
 */
@RestController
@RequestMapping(value = "/device")
@Api("终端管理接口")
public class Device {
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 查询指定厂商的所有的设备信息
     * @param cstype 厂商类型 01:海康 02:大华
     * @return 返回符合条件的所有终端列表
     */
    @ApiOperation(value = "终端管理查询",notes = "查询所有的终端信息列表，返回符合条件的所有终端列表")
    @RequestMapping(method = RequestMethod.GET, value = "")
    @ApiImplicitParam(name = "cstype",value = "厂商类型 01:海康 02:大华",required = true,dataType = "String")
    public List<Record> findAllTmnl(String cstype){
        List<Record> list = new ArrayList<>();
        if("01".equals(cstype)){
            list =  restTemplate.getForEntity("http://BCHT_ITS_DS_HK/device/",List.class).getBody();
        }else{
            list = restTemplate.getForEntity("http://BCHT_ITS_DS_DH/device/",List.class).getBody();
        }
        return list;
    }
}
