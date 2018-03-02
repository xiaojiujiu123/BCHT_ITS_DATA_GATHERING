package com.bcht.webservice.vehicle.client;

import com.bcht.webservice.vehicle.client.request.Info;
import com.bcht.webservice.vehicle.client.request.VehicleinfoRequest;
import com.bcht.webservice.vehicle.client.utils.PropertiesUtils;
import com.bcht.webservice.vehicle.client.utils.XstreamUtils;
import org.apache.axis.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2017/5/15.
 */
public class VehicleWebClient {
    private static Logger logger = LoggerFactory.getLogger(VehicleWebClient.class);
    private static final String XML_PREFIX = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private static final String XML_END = "";
    private static TransSoapBindingStub webClient = null;
    /**集中指挥平台的URL地址*/
    private static String url = PropertiesUtils.getValue("vehicle_webservice_url");
    /**集中指挥平台的序列号*/
    private static String serializ = PropertiesUtils.getValue("rminf_webservice_serializ");
    public static void initVehicleWebClient(){
        try {
            webClient = new TransSoapBindingStub(new URL(url), null);
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 过车数据上传接口调用
     * @param param 过车信息数据
     * @return 成功时，将返回写入记录的主键xh信息；错误时，如数据项不符合规则，则返回错误项字段名
     * @throws RemoteException
     */
    public static Long writerVehicleInfo(VehicleinfoRequest param){
        if(webClient == null){
            initVehicleWebClient();
        }
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + XstreamUtils.objectToXml(new Info()) + "\r\n";
        Long l= Long.valueOf(0);
        Long ll=Long.valueOf(0);
        try {
            ll=webClient.initTrans(param.getKkbh(),param.getFxlx(),Long.parseLong(param.getCdh()),xml);
        } catch (RemoteException e) {
            logger.error("初始化失败："+ll);
            return ll;
        }
        try {

            l= webClient.writeVehicleInfo(param.getKkbh(),param.getFxlx(),Long.parseLong(param.getCdh()),param.getHphm(),param.getHpzl(),param.getGcsj(),Long.parseLong(param.getClsd()),Long.parseLong(param.getClxs()),param.getWfdm(),Long.parseLong(param.getCwkc()),param.getHpys(),param.getCllx(),param.getFzhpzl(),param.getFzhphm(),param.getFzhpys(),param.getClpp(),param.getClwx(),param.getCsys(),param.getTplj(),param.getTp1(),param.getTp2(),param.getTp3(),param.getTztp());
        } catch (RemoteException e) {

            logger.error("接口地址连接失败！");
            return l;
        }
        //String xml = XML_PREFIX + XstreamUtils.objectToXml(param)+XML_END;
        return l;

    }
}
