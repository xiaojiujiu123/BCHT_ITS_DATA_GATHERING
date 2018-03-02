package com.bcht.its.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 百诚慧通写集成指挥平台统一接口定义
 */
@WebService
public interface BchtRminfo {

    /**
     * 百诚慧通读取集成指挥平台统一接口
     * @param xtlb 系统类别 详见具体查看接口定义
     * @param jkxlh 接口序号 申请接口后将自动下发接口序列号
     * @param jkid 接口ID 详见具体接口定义
     * @param QueryXmlDoc 查询条件 封装查询条件的XML格式文档
     * @return
     */
    String queryObjectOut(@WebParam(name = "xtlb") String xtlb, @WebParam(name = "jkxlh") String jkxlh, @WebParam(name = "jkid") String jkid, @WebParam(name = "QueryXmlDoc") String QueryXmlDoc);

    /**
     *  百诚慧通写入集成指挥平台统一接口
     * @param xtlb 系统类别 详见具体查看接口定义
     * @param jkxlh 接口序号 申请接口后将自动下发接口序列号
     * @param jkid 接口ID 详见具体接口定义
     * @param writeXmlDoc 业务数据写入XML格式文档
     * @return
     */
    String writeObjectOut(@WebParam(name = "xtlb") String xtlb, @WebParam(name = "jkxlh") String jkxlh, @WebParam(name = "jkid") String jkid, @WebParam(name = "writeXmlDoc") String writeXmlDoc);
}
