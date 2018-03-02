package com.bcht.its.webservice.impl;

import com.bcht.its.Application2;
import com.bcht.its.webservice.BchtRminfo;

import com.bcht.webservice.rminf.client.WebServiceClient;
import com.bcht.webservice.rminf.client.request.*;
import com.bcht.webservice.rminf.client.result.*;
import com.bcht.webservice.vehicle.client.VehicleWebClient;
import com.bcht.webservice.vehicle.client.request.*;
import com.bcht.webservice.vehicle.client.result.*;
import com.bcht.webservice.rminf.client.util.DmlxUtils;
import com.bcht.webservice.rminf.client.util.XstreamUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.BYTES;
import static java.lang.Integer.parseInt;


/**
 * Created by taosh on 2017/4/11.
 */
@WebService
public class BchtRminfoImpl implements BchtRminfo {
    private static Logger logger = LoggerFactory.getLogger(BchtRminfoImpl.class);
    private static final String XML_PREFIX = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<root>\r\n";
    private static final String XML_END = "\r\n</root>";

    @Override
    public String queryObjectOut(String xtlb, String jkxlh, String jkid, String QueryXmlDoc) {
        String xml ="";
        Head1 head1 = new Head1();
        //客运车辆信息核查
        if(Application2.qvehbusXtlb.equals(xtlb) && Application2.qvehbusJkid.equals(jkid)){
            xml = changeQvehbus(QueryXmlDoc,head1);
        }
        //交警执法站信息读取接口
        if(Application2.qstationXtlb.equals(xtlb) && Application2.qstationJkid.equals(jkid)){
            xml = changeQstation(QueryXmlDoc,head1);
        }
        //交警执法站关联卡口读取接口
        if(Application2.qstationrelationXtlb.equals(xtlb) && Application2.qstationrelationJkid.equals(jkid)){
            xml = changeQstationRelation(QueryXmlDoc,head1);
        }
        //交警执法站关联警员信息读取接口
        if(Application2.qstationpersonXtlb.equals(xtlb) && Application2.qstationpersonJkid.equals(jkid)){
            xml = changeQstationperson(QueryXmlDoc,head1);
        }
        return xml;
    }

    private String changeQstationperson(String queryXmlDoc, Head1 head1) {
        String xml = "";
        QstationpersonRes qs = XstreamUtils.xmlToObject(queryXmlDoc,QstationpersonRes.class);
        QstationpersonRequest qstationperson = qs.getQstationpersonRequest();
        if(StringUtils.isBlank(qstationperson.getFwzbh())){
            return packXml1(head1,"fwzbh","1");
        }
        try {
            getAndSet(qstationperson);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.queryStationperson(qstationperson);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }



    private String changeQstationRelation(String queryXmlDoc, Head1 head1) {
        String xml = "";
        QstationRelationRes QstationRelationRes = XstreamUtils.xmlToObject(queryXmlDoc,QstationRelationRes.class);
        QstationRelationRequest qstationRelation = QstationRelationRes.getQstationRelationRequest();
        if(StringUtils.isBlank(qstationRelation.getFwzbh())){
            return packXml1(head1,"fwzbh","1");
        }
        try {
            getAndSet(qstationRelation);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.queryStationRelation(qstationRelation);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changeQstation(String queryXmlDoc, Head1 head1) {
        String xml = "";
        QstationRes qstationRes = XstreamUtils.xmlToObject(queryXmlDoc,QstationRes.class);
        QstationRequest qstation = qstationRes.getQstationRequest();
        if(StringUtils.isBlank(qstation.getGlbmt())){
            return packXml1(head1,"glbm","1");
        }
        if(qstation.getGlbmt().length() < 4){
            return packXml1(head1,"glbm","0");
        }
        try {
            getAndSet(qstation);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.queryStation(qstation);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changeQvehbus(String queryXmlDoc, Head1 head1) {
        String xml = "";
        QvehbusRes qvehbusRes = XstreamUtils.xmlToObject(queryXmlDoc, QvehbusRes.class);
        QvehbusRequest qvehbus = qvehbusRes.getQvehbusRequest();
        /*if(!"01".equals(qvehbus.getHpzl())){
            return packXml1(head1,"hpzl","0");
        }*/
        try {
            getAndSet(qvehbus);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.queryVehBus(qvehbus);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    @Override
    public String writeObjectOut(String xtlb, String jkxlh, String jkid, String writeXmlDoc) {
        String xml = "";
        Head head = new Head();
        //非现场违法待筛选写入
        if(Application2.surscreeXtlb.equals(xtlb) && Application2.surscreeJkid.equals(jkid)){
            xml = changeSurscree(writeXmlDoc,head);
        }
        //非现场违法待审核写入
        if(Application2.surexamineXtlb.equals(xtlb) && Application2.surexamineJkid.equals(jkid)){
            xml = changeSurexamine(writeXmlDoc,head);
        }
        //交通流量信息写入
        if(Application2.flowequipXtlb.equals(xtlb) && Application2.flowequipJkid.equals(jkid)){
            xml = changeFlowequip(writeXmlDoc,head);
        }
        //交通气象信息写入
        if(Application2.weatherXtlb.equals(xtlb) && Application2.weatherJkid.equals(jkid)){
            xml = changeWeather(writeXmlDoc,head);
        }
        //交通事件信息写入
        if(Application2.incidentXtlb.equals(xtlb) && Application2.incidentJkid.equals(jkid)){
            xml = changeIncident(writeXmlDoc,head);
        }
        //交通诱导发布信息写入
        if(Application2.inducementXtlb.equals(xtlb) && Application2.inducementJkid.equals(jkid)){
            xml = changeInducement(writeXmlDoc,head);
        }
        //警车定位信息写入接口
        if(Application2.carXtlb.equals(xtlb) && Application2.carJkid.equals(jkid)){
            xml = changeCar(writeXmlDoc,head);
        }
        //单警定位信息写入接口
        if(Application2.policeXtlb.equals(xtlb) && Application2.policeJkid.equals(jkid)){
            xml = changePolice(writeXmlDoc,head);
        }
        //停车场车辆信息写入
        if(Application2.parkXtlb.equals(xtlb) && Application2.parkJkid.equals(jkid)){
            xml = changePark(writeXmlDoc,head);
        }
        //车辆检查台账写入
        if(Application2.vehcheckXtlb.equals(xtlb) && Application2.vehcheckJkid.equals(jkid)){
            xml = changeVehcheck(writeXmlDoc,head);
        }
        //预警反馈信息写入
        if(Application2.feedbackXtlb.equals(xtlb) && Application2.feedbackJkid.equals(jkid)){
            xml = changeFeedback(writeXmlDoc,head);
        }
        //拦截处置图片上传接口
        if(Application2.feedbackpicXtlb.equals(xtlb) && Application2.feedbackpicJkid.equals(jkid)){
            xml = changeFeedbackpic(writeXmlDoc,head);
        }
        //过车数据上传接口
        if(Application2.vehicleinfoXtlb.equals(xtlb) && Application2.vehicleinfoJkid.equals(jkid)){
            try {
                xml = changeVehicleInfo(writeXmlDoc,head);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return xml;
    }

    private String changeVehicleInfo(String writeXmlDoc, Head head) throws RemoteException {
        String xml="";
        VehicleinfoRes vehicleinfoRes = XstreamUtils.xmlToObject(writeXmlDoc,VehicleinfoRes.class);
        VehicleinfoRequest vehicleInfo = vehicleinfoRes.getVehicleinfoRequest();
        if(vehicleInfo.getFxlx().equals("2")&&vehicleInfo.getKkbh().equals("630000100454")){
            System.out.println("x");
        }
        if(StringUtils.isBlank(vehicleInfo.getKkbh())){
            return packXml(head,"kkbh","1");
        }
        if(StringUtils.isBlank(vehicleInfo.getFxlx())){
            return packXml(head,"fxlx","1");
        }
        if(StringUtils.isBlank(vehicleInfo.getCdh())){
            return packXml(head,"cdh","1");
        }
        if(StringUtils.isBlank(vehicleInfo.getHphm())){
            return packXml(head,"hphm","1");
        }
        if(StringUtils.isBlank(vehicleInfo.getHpzl())){
            return packXml(head,"hpzl","1");
        }
        if(StringUtils.isBlank(vehicleInfo.getGcsj())){
            return packXml(head,"gcsj","1");
        }
        if(StringUtils.isBlank(vehicleInfo.getClsd())){
            return packXml(head,"clsd","1");
        }
        if(StringUtils.isBlank(vehicleInfo.getClxs())){
            return packXml(head,"clxs","1");
        }
        if(StringUtils.isBlank(vehicleInfo.getCwkc())){
            return packXml(head,"cwkc","1");
        }
        if(StringUtils.isBlank(vehicleInfo.getHpys())){
            return packXml(head,"hpys","1");
        }
        if(StringUtils.isBlank(vehicleInfo.getTplj())){
            return packXml(head,"tplj","1");
        }
        String clsd=(int)Float.parseFloat(vehicleInfo.getClsd())+"";
        String cwkc =(int)Float.parseFloat(vehicleInfo.getCwkc())+"";
        vehicleInfo.setClsd(clsd);
        vehicleInfo.setCwkc(cwkc);
        if("无牌".equals(vehicleInfo.getHphm()) || "未识别".equals(vehicleInfo.getHphm()) || "无法识别".equals(vehicleInfo.getHphm())){
            if("无牌".equals(vehicleInfo.getHphm()) && !"41".equals(vehicleInfo.getHpzl())){
                return packXml(head,"hpzl","0");
            }
            if("无法识别".equals(vehicleInfo.getHphm()) && !"44".equals(vehicleInfo.getHpzl())){
                return packXml(head,"hpzl","0");
            }
            vehicleInfo.setHphm("-");
        }
        if(StringUtils.isNotBlank(vehicleInfo.getFzhphm())){
            if("无牌".equals(vehicleInfo.getFzhphm()) || "未识别".equals(vehicleInfo.getFzhphm()) || "无法识别".equals(vehicleInfo.getFzhphm())){
                if("无牌".equals(vehicleInfo.getFzhphm()) && !"41".equals(vehicleInfo.getHpzl())){
                    return packXml(head,"hpzl","0");
                }
                vehicleInfo.setFzhphm("-");
            }
        }
        if(StringUtils.isNotBlank(vehicleInfo.getFzhpzl())){
            Boolean boo = DmlxUtils.VCA_PLATE_HPZL.getPlate(vehicleInfo.getFzhpzl());
            if(!boo){
                return packXml(head,"fzhpzl","0");
            }
        }

        if(StringUtils.isNotBlank(vehicleInfo.getHpzl())){
            Boolean boo = DmlxUtils.VCA_PLATE_HPZL.getPlate(vehicleInfo.getHpzl());
            if(!boo){
                return packXml(head,"hpzl","0");
            }
        }
        if(StringUtils.isNotBlank(vehicleInfo.getHpys())){
            Boolean boo = DmlxUtils.VCA_PLATE_COLOR.getPlate(vehicleInfo.getHpys());
                if (!boo){
                    return packXml(head,"hpys","0");
                }
        }
        if(vehicleInfo.getHpzl().equals("99")){
            return packXml(head,"hpzl","0");
        }
        if(StringUtils.isNotBlank(vehicleInfo.getCllx())){
            Boolean boo = DmlxUtils.VCA_PLATE_CLLX.getPlate(vehicleInfo.getCllx());
            if(!boo){
                return packXml(head,"cllx","0");
            }
        }
        if(StringUtils.isNotBlank(vehicleInfo.getFzhpys())){
            Boolean boo = DmlxUtils.VCA_PLATE_COLOR.getPlate(vehicleInfo.getFzhpys());
                if (!boo){
                    return packXml(head,"fzhpys","0");
                }
        }
        if(StringUtils.isNotBlank(vehicleInfo.getCsys())){
            Boolean boo = DmlxUtils.VCA_PLATE_CSYS.getPlate(vehicleInfo.getCsys());
            if (!boo){
                return packXml(head,"csys","0");
            }
        }
        try {
            getAndSet(vehicleInfo);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        xml= String.valueOf(VehicleWebClient.writerVehicleInfo(vehicleInfo));
        if(xml.equals("1")){
            /*if(vehicleInfo.getKkbh().equals("533600100064")){
                System.out.println(1);
                if(vehicleInfo.getCdh().equals("2")){
                    System.out.println(1);
                }

            }*/
            logger.info("上传成功----集成编号"+vehicleInfo.getKkbh()+",过车时间："+vehicleInfo.getGcsj()+"号牌号码："+vehicleInfo.getHphm()+",号牌种类："+vehicleInfo.getHpzl()+",图片地址："+vehicleInfo.getTplj()+vehicleInfo.getTp1());
            if(vehicleInfo.getKkbh().equals("533600100064")){
                logger.info("车道号:"+vehicleInfo.getCdh());
            }
        }else{
            logger.info("上传失败----集成编号"+vehicleInfo.getKkbh()+",返回值："+xml+",车道号："+vehicleInfo.getCdh()+",方向："+vehicleInfo.getFxlx()+",过车时间："+vehicleInfo.getGcsj()+"号牌号码："+vehicleInfo.getHphm()+",号牌种类："+vehicleInfo.getHpzl()+",图片地址："+vehicleInfo.getTplj()+vehicleInfo.getTp1());
        }
        return xml;
    }

    private String changeFeedbackpic(String writeXmlDoc, Head head) {
        String xml="";
        FeedbackpicRes feedbackpicRes = XstreamUtils.xmlToObject(writeXmlDoc,FeedbackpicRes.class);
        FeedbackpicRequest feedbackpic = feedbackpicRes.getFeedbackpicRequest();
        if(StringUtils.isBlank(feedbackpic.getYjxh())){//预警序号为空
            return packXml(head,"yjxh","1");
        }
        if(StringUtils.isBlank(feedbackpic.getTp1())){//图片1为空
            return packXml(head,"tp1","1");
        }
        if(StringUtils.isBlank(feedbackpic.getScdw())){//上传单位为空
            return packXml(head,"scdw","1");
        }
        if(StringUtils.isBlank(feedbackpic.getScr())){//上传人为空
            return packXml(head,"scr","1");
        }
        try {
            getAndSet(feedbackpic);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerFeedbackpic(feedbackpic);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changeFeedback(String writeXmlDoc, Head head) {
        String xml="";
        FeedbackRes feedbackRes = XstreamUtils.xmlToObject(writeXmlDoc,FeedbackRes.class);
        FeedbackRequest feedback = feedbackRes.getFeedbackRequest();
        if(StringUtils.isBlank(feedback.getYjxh())){//预警序号为空
            return packXml(head,"yjxh","1");
        }
        if(StringUtils.isBlank(feedback.getYwlx())){//业务类型为空
            return packXml(head,"ywlx","1");
        }
        if(StringUtils.isBlank(feedback.getCzdw())){//处置单位为空
            return packXml(head,"czdw","1");
        }
        if(StringUtils.isBlank(feedback.getCzr())){//处置民警为空
            return packXml(head,"czr","1");
        }
        if(StringUtils.isBlank(feedback.getCzsj())){//处置时间为空
            return packXml(head,"czsj","1");
        }
        if("1".equals(feedback.getYwlx())){//业务类型为“1”时
            if(StringUtils.isBlank(feedback.getQsjg())){//签收结果为空
                return packXml(head,"qsjg","1");
            }
            if("1".equals(feedback.getQsjg()) && StringUtils.isBlank(feedback.getSfcjlj())){//签收结果为“1”，并且是否出警为空
                return packXml(head,"sfcjlj","1");
            }
        }
        if("2".equals(feedback.getYwlx())){//业务类型为“2”时
            if(StringUtils.isBlank(feedback.getLjclqk())){//拦截车辆情况为空
                return packXml(head,"ljclqk","1");
            }
            if("1".equals(feedback.getLjclqk())){//拦截车辆情况为“1”时
                if(StringUtils.isBlank(feedback.getChjg())){//是否嫌疑车辆为空
                    return packXml(head,"chjg","1");
                }
                if("1".equals(feedback.getChjg())){//是嫌疑车辆
                    if(StringUtils.isBlank(feedback.getCljg())){//处置结果为空
                        return packXml(head,"cljg","1");
                    }
                }
                if("0".equals(feedback.getChjg())){//不是嫌疑车辆
                    if(StringUtils.isBlank(feedback.getWchyy())) {//非嫌疑车辆原因为空
                        return packXml(head,"wchyy","1");
                    }
                }
            }
            if("0".equals(feedback.getLjclqk())) {//拦截车辆情况为“0”时
                if(StringUtils.isBlank(feedback.getWljdyy())) {//未拦截到原因为空
                    return packXml(head,"wljdyy","1");
                }
            }
        }
        if(StringUtils.isNotBlank(feedback.getCljg()) && feedback.getCljg().contains("2")){//处置结果包含"2"时
            if(StringUtils.isBlank(feedback.getWsbh())){//法律文书编号为空
                return packXml(head,"wsbh","1");
            }
            if(StringUtils.isBlank(feedback.getJyw())){//文书校验位为空
                return packXml(head,"jyw","1");
            }
            if(StringUtils.isBlank(feedback.getWslb())){//文书类别为空
                return packXml(head,"wslb","1");
            }
        }else{
            if(StringUtils.isNotBlank(feedback.getWsbh())){//法律文书编号不为空
                return packXml(head,"wsbh","0");
            }
            if(StringUtils.isNotBlank(feedback.getJyw())){//文书校验位不为空
                return packXml(head,"jyw","0");
            }
            if(StringUtils.isNotBlank(feedback.getWslb())){//文书类别不为空
                return packXml(head,"wslb","0");
            }
        }
        try {
            getAndSet(feedback);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerFeedback(feedback);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changeVehcheck(String writeXmlDoc, Head head) {
        String xml="";
        VehcheckRes vehcheckRes = XstreamUtils.xmlToObject(writeXmlDoc,VehcheckRes.class);
        VehcheckRequest vehcheck = vehcheckRes.getVehcheckRequest();
        if(StringUtils.isBlank(vehcheck.getFwzbh())){
            return packXml(head,"fwzbh","1");
        }
        if(StringUtils.isBlank(vehcheck.getClzt())){
            return packXml(head,"clzt","1");
        }
        if(StringUtils.isBlank(vehcheck.getHpzl())){
            return packXml(head,"hpzl","1");
        }
        if(StringUtils.isBlank(vehcheck.getHphm())){
            return packXml(head,"hphm","1");
        }
        if(StringUtils.isBlank(vehcheck.getJccllx())){
            return packXml(head,"jccllx","1");
        }
        if(StringUtils.isBlank(vehcheck.getSfd())){
            return packXml(head,"sfd","1");
        }
        if(StringUtils.isBlank(vehcheck.getMdd())){
            return packXml(head,"mdd","1");
        }
        if(StringUtils.isBlank(vehcheck.getJcjg())){
            return packXml(head,"jcjg","1");
        }
        if(StringUtils.isBlank(vehcheck.getJcsj())){
            return packXml(head,"jcsj","1");
        }
        if(StringUtils.isBlank(vehcheck.getJcmj())){
            return packXml(head,"jcmj","1");
        }
        if(StringUtils.isBlank(vehcheck.getZjszh())){
            return packXml(head,"zjszh","1");
        }
        if("1".equals(vehcheck.getSfyfjsy()) && StringUtils.isBlank(vehcheck.getFjszh())){
            return packXml(head,"fjszh","1");
        }
        if("41".equals(vehcheck.getHpzl()) && !"-".equals(vehcheck.getHphm())){
            return packXml(head,"hpzl,hphm","0");
        }
        if("2".equals(vehcheck.getClzt()) && !"41".equals(vehcheck.getHpzl())){
            return packXml(head,"clzt,hpzl","0");
        }

        if("04".equals(vehcheck.getJccllx())){
            if(!"".equals(common(head,vehcheck))){
                return common(head, vehcheck);
            }
            if(StringUtils.isBlank(vehcheck.getZtfgbs())){//是否按规定粘贴反光标识
                return packXml(head,"ztfgbs","1");
            }
            if(StringUtils.isBlank(vehcheck.getAzfhzz())){//是否安装侧后防护装置
                return packXml(head,"azfhzz","1");
            }
            if(StringUtils.isBlank(vehcheck.getFfgz())){//是否非法改装超载
                return packXml(head,"ffgz","1");
            }
            if(StringUtils.isBlank(vehcheck.getSjzzl())){//实际载质量
                return packXml(head,"sjzzl","1");
            }else{
                return common(head,vehcheck);
            }
        }
        if("01".equals(vehcheck.getJccllx()) || "03".equals(vehcheck.getJccllx())){
            if(!"".equals(common(head,vehcheck))){
                return common(head, vehcheck);
            }
            if(StringUtils.isBlank(vehcheck.getWfyy())){//是否违法营运
                return packXml(head,"wfyy","1");
            }
            if(StringUtils.isBlank(vehcheck.getZks())){//实际载客数
                return packXml(head,"zks","1");
            }
        }
        if("02".equals(vehcheck.getJccllx())){
            if(!"".equals(common(head,vehcheck))){
                return common(head, vehcheck);
            }
            if(StringUtils.isBlank(vehcheck.getXgjsbz())) {//是否悬挂或喷涂警示标志
                return packXml(head, "xgjsbz", "1");
            }
            if(StringUtils.isBlank(vehcheck.getAzdsj())){//是否按指定时间行驶
                return packXml(head,"azdsj","1");
            }
            if(StringUtils.isBlank(vehcheck.getAzdlx())){//是否按指定路线行驶
                return packXml(head,"azdlx","1");
            }
            if(StringUtils.isBlank(vehcheck.getQdystxz())){//是否取得道路运输通行证
                return packXml(head,"qdystxz","1");
            }

        }
        if("05".equals(vehcheck.getJccllx())){
            if(!"".equals(common(head,vehcheck))){
                return common(head, vehcheck);
            }
        }
        try {
            getAndSet(vehcheck);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerVehcheck(vehcheck);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String common(Head head,VehcheckRequest vehcheck) {
        if(StringUtils.isBlank(vehcheck.getPljs())){//是否疲劳驾驶
            return packXml(head,"pljs","1");
        }
        if(StringUtils.isBlank(vehcheck.getAqsb())){//安全设备是否合格
            return packXml(head,"aqsb","1");
        }
        if(StringUtils.isBlank(vehcheck.getCllthw())){//车辆轮胎花纹是否合格
            return packXml(head,"cllthw","1");
        }
        if(StringUtils.isBlank(vehcheck.getJaqd())){//是否系安全带
            return packXml(head,"jaqd","1");
        }
        return "";
    }

    private String changePark(String writeXmlDoc, Head head) {
        String xml ="";
        ParkRes parkRes = XstreamUtils.xmlToObject(writeXmlDoc,ParkRes.class);
        ParkRequest park = parkRes.getParkRequest();
        if(StringUtils.isBlank(park.getTCCBH())){
            return packXml(head,"TCCBH","1");
        }
        if(StringUtils.isBlank(park.getFXLX())){
            return packXml(head,"FXLX","1");
        }
        if(StringUtils.isBlank(park.getTXSJ())){
            return packXml(head,"TXSJ","1");
        }
        if(StringUtils.isBlank(park.getHPHM())){
            return packXml(head,"HPHM","1");
        }
        if(StringUtils.isBlank(park.getHPZL())){
            return packXml(head,"HPZL","1");
        }
        if(!"1".equals(park.getFXLX()) && !"2".equals(park.getFXLX())){
            return packXml(head,"FXLX","0");
        }
        if(StringUtils.isNotBlank(park.getHPZL())){
            Boolean boo = DmlxUtils.VCA_PLATE_HPZL.getPlate(park.getHPZL());
            if(!boo){
                return packXml(head,"HPZL","0");
            }
        }

        if(StringUtils.isNotBlank(park.getHPYS())){
            Boolean boo = DmlxUtils.VCA_PLATE_COLOR.getPlate(park.getHPYS());
            if(!boo){
                return packXml(head,"HPYS","0");
            }
        }
        if(StringUtils.isNotBlank(park.getCSYS())){
            Boolean boo = DmlxUtils.VCA_PLATE_CSYS.getPlate(park.getCSYS());
            if(!boo){
                return packXml(head,"CSYS","0");
            }
        }
        if(StringUtils.isNotBlank(park.getCLLX())){
            Boolean boo = DmlxUtils.VCA_PLATE_CLLX.getPlate(park.getCLLX());
            if(!boo){
                return packXml(head,"CLLX","0");
            }
        }
        try {
            getAndSet(park);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerPark(park);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changePolice(String writeXmlDoc, Head head) {
        String xml ="";
        PoliceRes policeRes = XstreamUtils.xmlToObject(writeXmlDoc,PoliceRes.class);
        PoliceRequest police = policeRes.getPoliceRequest();
        if(StringUtils.isBlank(police.getSBSJ())){
            return packXml(head,"SBSJ","1");
        }
        if(StringUtils.isBlank(police.getJD())){
            return packXml(head,"JD","1");
        }
        if(StringUtils.isBlank(police.getWD())){
            return packXml(head,"WD","1");
        }
        if(StringUtils.isNotBlank(police.getRYLX()) && !"1".equals(police.getRYLX()) && !"2".equals(police.getRYLX())){//人员类型不为空时,必须是1或2
            return packXml(head,"RYLX","0");
        }
        if(StringUtils.isBlank(police.getGPSBH()) && StringUtils.isBlank(police.getRYBH())){
            return packXml(head,"GPSBH,RYBH","1");
        }
        try {
            getAndSet(police);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerPolice(police);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changeCar(String writeXmlDoc, Head head) {
        String xml = "";
        CarRes carRes = XstreamUtils.xmlToObject(writeXmlDoc,CarRes.class);
        CarRequest car = carRes.getCarRequest();
        if(StringUtils.isBlank(car.getSBSJ())){
            return packXml(head,"SBSJ","1");
        }
        if(StringUtils.isBlank(car.getJD())){
            return packXml(head,"JD","1");
        }
        if(StringUtils.isBlank(car.getWD())){
            return packXml(head,"WD","1");
        }
        if(StringUtils.isBlank(car.getGPSBH()) && StringUtils.isBlank(car.getHPHM()) && StringUtils.isBlank(car.getHPZL())){
            return packXml(head,"GPSBH,HPHM,HPZL","1");
        }
        try {
            getAndSet(car);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerCar(car);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changeInducement(String writeXmlDoc, Head head) {
        String xml ="";
        InducementRes inducementRes = XstreamUtils.xmlToObject(writeXmlDoc,InducementRes .class);
        InducementRequest inducement = inducementRes.getInducementRequest();
        if(StringUtils.isNotBlank(inducement.getQSSJ()) && StringUtils.isNotBlank(inducement.getJSSJ())){
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date dt1 = (Date)df.parse(inducement.getQSSJ());
                Date dt2 = (Date)df.parse(inducement.getJSSJ());
                if(dt1.getTime()>dt2.getTime()){
                    //起始时间大于结束时间
                    return packXml(head,"QSSJ,JSSJ","4");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        if(StringUtils.isBlank(inducement.getSBBH())){
            return packXml(head,"SBBH","1");
        }
        if(StringUtils.isBlank(inducement.getFBSJ())){
            return packXml(head,"FBSJ","1");
        }
        if(StringUtils.isBlank(inducement.getXXLX())){
            return packXml(head,"SJLX","1");
        }
        if(StringUtils.isBlank(inducement.getFBFS())){
            return packXml(head,"FBFS","1");
        }
        if(StringUtils.isBlank(inducement.getJLZT())){
            return packXml(head,"JLZT","1");
        }
        if(StringUtils.isBlank(inducement.getFBYH())){
            return packXml(head,"FBYH","1");
        }
        if(!"0".equals(inducement.getJLZT()) && !"1".equals(inducement.getJLZT())){
            return packXml(head,"JLZT","0");
        }
        if(StringUtils.isNotBlank(inducement.getXXLX())){
            Boolean boo = DmlxUtils.VCA_PLATE_XXLX.getPlate(inducement.getXXLX());
            if(!boo){
                return packXml(head,"XXLX","0");
            }
        }
        if(StringUtils.isNotBlank(inducement.getFBFS())){
            if(!"1".equals(inducement.getFBFS()) && !"2".equals(inducement.getFBFS()) && !"3".equals(inducement.getFBFS())){
                return packXml(head,"FBFS","0");
            }
        }
        try {
            getAndSet(inducement);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerInducement(inducement);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changeIncident(String writeXmlDoc, Head head) {
        String xml = "";
        IncidentRes incidentRes = XstreamUtils.xmlToObject(writeXmlDoc,IncidentRes.class);
        IncidentRequest incident = incidentRes.getIncidentRequest();
        if(StringUtils.isBlank(incident.getSBLY())){
            return packXml(head,"SBLY","1");
        }
        if(StringUtils.isBlank(incident.getSBBH())){
            return packXml(head,"SBBH","1");
        }
        if(StringUtils.isBlank(incident.getJCSJ())){
            return packXml(head,"JCSJ","1");
        }
        if(StringUtils.isBlank(incident.getSJLX())){
            return packXml(head,"SJLX","1");
        }
        if(StringUtils.isBlank(incident.getSPXX())){
            return packXml(head,"SPXX","1");
        }
        if(!"1".equals(incident.getSBLY()) && !"2".equals(incident.getSBLY())){
            return packXml(head,"SBLY","0");
        }
        if("1".equals(incident.getSBLY())){
            if(incident.getSBBH().length() != 18){
                return packXml(head,"SBBH","2");
            }
        }
        if("2".equals(incident.getSBLY())){
            if(incident.getSBBH().length() > 19){
                return packXml(head,"SBBH","3");
            }
        }
        if(StringUtils.isNotBlank(incident.getSJLX())){
            Boolean boo = DmlxUtils.VCA_PLATE_SJLX.getPlate(incident.getSJLX());
            if(!boo){
                return packXml(head,"SJLX","0");
            }
        }
        try {
            getAndSet(incident);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerIncident(incident);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changeWeather(String writeXmlDoc, Head head) {
        String xml ="";
        String[] array = {"E","S","W","N","SE","SW","NW","NE"};//定义风向代码数组
        String[] array1 = {"A","D","E","G","J"};//定义检测事件类型数组
        WeatherRes weatherRes = XstreamUtils.xmlToObject(writeXmlDoc,WeatherRes.class);
        WeatherRequest weather = weatherRes.getWeatherRequest();
        if(StringUtils.isBlank(weather.getSBBH())){
            return packXml(head,"SBBH","1");
        }
        if(StringUtils.isBlank(weather.getJCSD())){
            return packXml(head,"JCSD","1");
        }
        if(StringUtils.isBlank(weather.getJCZQS())){
            return packXml(head,"JCZQS","1");
        }
        if(StringUtils.isBlank(weather.getJCSJ())){
            return packXml(head,"JCSJ","1");
        }
        if(StringUtils.isBlank(weather.getNJD())){
            return packXml(head,"NJD","1");
        }
        if(StringUtils.isNotBlank(weather.getFX())){
            List<String> list= Arrays.asList(array);
            if(list.contains(weather.getFX())){
            }else{
                return packXml(head,"FX","0");
            }
        }
        if(StringUtils.isNotBlank(weather.getJCSJLX())){
            String[] array2 = weather.getJCSJLX().split("");
            List<String> list1= Arrays.asList(array1);
            for(int i=0;i<array2.length;i++){
                if(list1.contains(array2[i])){

                }else{
                    return packXml(head,"JCSJLX","0");
                }
            }
        }
        try {
            getAndSet(weather);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerWeather(weather);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changeFlowequip(String writeXmlDoc, Head head) {
        String xml = "";
        FlowequipRes flowequipRes = XstreamUtils.xmlToObject(writeXmlDoc,FlowequipRes.class);
        FlowequipRequest flowequip = flowequipRes.getFlowequipRequest();
        if(StringUtils.isBlank(flowequip.getSBBH())){
            return packXml(head,"SBBH","1");
        }
        if(StringUtils.isBlank(flowequip.getTJSD())){
            return packXml(head,"TJSD","1");
        }
        if(StringUtils.isBlank(flowequip.getTJZQS())){
            return packXml(head,"TJZQS","1");
        }
        if(StringUtils.isBlank(flowequip.getTXCLS())){
            return packXml(head,"TXCLS","1");
        }
        if(flowequip.getTJSD().length() != 10){
            return packXml(head,"TJSD","0");
        }
        if(StringUtils.isNotBlank(flowequip.getDCS())){//验证大车数是否为空
            if(StringUtils.isNotBlank(flowequip.getXCS())){//验证小车数是否为空
                if((parseInt(flowequip.getDCS()) + parseInt(flowequip.getXCS())) > parseInt(flowequip.getTXCLS())){
                    return packXml(head,"DCS,XCS,TXCLS","0");
                }
            }
            if(parseInt(flowequip.getDCS()) > parseInt(flowequip.getTXCLS())){
                return packXml(head,"DCS,TXCLS","0");
            }
        }
        if(StringUtils.isNotBlank(flowequip.getXCS())){//大车数为空时，验证小车数是否为空
            if(parseInt(flowequip.getXCS()) > parseInt(flowequip.getTXCLS())){
                return packXml(head,"XCS,TXCLS","0");
            }
        }
        if(StringUtils.isBlank(String.valueOf(flowequip.getPJSD()))){
            return packXml(head,"PJSD","1");
        }
        try {
            getAndSet(flowequip);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerFlowequip(flowequip);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changeSurexamine(String writeXmlDoc, Head head) {
        String xml = "";
        SurexamineRes surexamineRes = XstreamUtils.xmlToObject(writeXmlDoc,SurexamineRes.class);
        SurexamineRequest surexamine = surexamineRes.getSurexamineRequest();
        String clfl = surexamine.getClfl();
        if(StringUtils.isBlank(surexamine.getSbbh())){
            return packXml(head,"sbbh","1");
        }
        if(StringUtils.isBlank(clfl)){
            return packXml(head,"clfl","1");
        }
        if(!clfl.equals("3") && !clfl.equals("4") && !clfl.equals("5") && !clfl.equals("6")){
            return packXml(head,"clfl","0");
        }
        if(StringUtils.isBlank(surexamine.getHpzl())){
            return packXml(head,"hphm","1");
        }
        if(StringUtils.isBlank(surexamine.getHphm())){
            return packXml(head,"hpzl","1");
        }
        if(!"3".equals(clfl)){
            if(StringUtils.isBlank(surexamine.getFzjg())){
                return packXml(head,"fzjg","1");
            }
            if(StringUtils.isBlank(surexamine.getJdcsyr())){
                return packXml(head,"jdcsyr","1");
            }
            if(StringUtils.isBlank(surexamine.getJtfs())){
                return packXml(head,"jtfs","1");
            }
        }
        if(StringUtils.isBlank(surexamine.getWfsj())){
            return packXml(head,"wfsj","1");
        }
        if(StringUtils.isBlank(surexamine.getWfxw())){
            return packXml(head,"wfxw","1");
        }
        if(StringUtils.isNotBlank(surexamine.getWfxw()) && surexamine.getWfxw().length() != 4 && surexamine.getWfxw().length() != 5){
            return packXml(head,"wfxw","0");
        }
        if(StringUtils.isBlank(surexamine.getZpsl())){
            return packXml(head,"zpsl","1");
        }
        if(StringUtils.isBlank(surexamine.getZpstr1())){
            return packXml(head,"zpstr1","1");
        }
        try {
            getAndSet(surexamine);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerSurexamine(surexamine);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String changeSurscree(String writeXmlDoc,Head head) {
        String xml ="";
        SurscreeRes surscreeRes = XstreamUtils.xmlToObject(writeXmlDoc,SurscreeRes.class);
        String clfl = surscreeRes.getSurscreeRequest().getClfl();
        SurscreeRequest surscree = surscreeRes.getSurscreeRequest();
        if(StringUtils.isNotBlank(clfl) && !clfl.equals("3") && !clfl.equals("4") && !clfl.equals("5") && !clfl.equals("6")){
            xml = packXml(head,"clfl","0");
            return xml;
        }
//            if(StringUtils.isNotBlank(surscree.getWfsj())){
//                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD hh24:mi:ss");
//                surscree.setWfsj(sdf.format());
//            }
        if(StringUtils.isBlank(surscree.getZpstr1())){
            return packXml(head,"zpstr1","1");
        }
        if(StringUtils.isBlank(surscree.getSbbh())){
            return packXml(head,"sbbh","1");
        }
        if(StringUtils.isBlank(surscree.getZpsl())){
            return packXml(head,"zpsl","1");
        }

        try {
            getAndSet(surscree);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            xml = WebServiceClient.writerSurscreen(surscree);
        } catch (RemoteException e) {
            logger.error("集成平台接口地址连接超时！");
            return "集成平台接口地址连接超时！";
        }
        return xml;
    }

    private String packXml(Head head,String field,String cwbs){
        head.setCode(0);
        head.setValue(field);
        switch (cwbs){
            case "0" : head.setMessage(field+"不符合定义规范!");
                        break;
            case "1" : head.setMessage(field+"为空!");
                        break;
            case "2" : head.setMessage(field+"不是18位!");
                        break;
            case "3" : head.setMessage(field+"大于19位!");
                        break;
            case "4" : head.setMessage("起始时间大于结束时间！");
                        break;
        }
        return XML_PREFIX + XstreamUtils.objectToXml(head) + XML_END;
    }

    private String packXml1(Head1 head1, String field, String cwbs) {
        head1.setCode(0);
        head1.setRownum("0");
        switch (cwbs){
            case "1" : head1.setMessage(field+"为空！");
                        break;
            case "0" : head1.setMessage(field+"不符合定义规范!");
                        break;
        }
        return XML_PREFIX + XstreamUtils.objectToXml(head1) + XML_END;
    }

    private void  getAndSet(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            //获取属性名
            String name = fields[i].getName();
            //将属性的首字母大写
            name=name.substring(0,1).toUpperCase() + name.substring(1);
            //获取属性的类型
            String type= fields[i].getGenericType().toString();
            if(type.equals("class java.lang.String")){
                Method m = obj.getClass().getMethod("get"+name);
                //调用getter方法获取属性值
                String value=(String) m.invoke(obj);
                Class[] paramterTypes=new Class[1];
                paramterTypes[0]=fields[i].getType();
                m=obj.getClass().getMethod("set"+name,paramterTypes);
                Object[] objects = new Object[1];
                objects[0]=value;
                Object[] objects1 = new Object[1];
                objects1[0]="";
                if(StringUtils.isNotBlank(value)){
                    //set值
                    m.invoke(obj,objects);
                }else{
                    m.invoke(obj,objects1);
                }
            }
        }
    }
}
