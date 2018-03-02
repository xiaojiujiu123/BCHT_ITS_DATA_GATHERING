package com.bcht.its.restful;

import com.bcht.its.commons.beans.TerminalInfo;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询所有终端信息
 */
@RestController
@RequestMapping(value = "/tmnl")
@Api("终端管理接口")
public class TmnlController {
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 查询指定厂商的所有的终端信息
     * @param cstype 厂商类型 01:海康 02:大华
     * @return 返回符合条件的所有终端列表
     */
    @ApiOperation(value = "终端管理查询",notes = "查询所有的终端信息列表，返回符合条件的所有终端列表")
    @RequestMapping(method = RequestMethod.GET, value = "")
    @ApiImplicitParam(name = "cstype",value = "厂商类型 01:海康 02:大华",required = true,dataType = "String")
    public List<TerminalInfo> findAllTmnl(String cstype){
        List<TerminalInfo> list = new ArrayList<>();
        list =  restTemplate.getForEntity("http://BCHT_ITS_DS_HK/terminal/findAllterminalInfo",List.class).getBody();
        return list;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "terminalInfo", value = "用户详细实体user", required = true, dataType = "TerminalInfo")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody TerminalInfo terminalInfo) {
        return "success";
    }
}
