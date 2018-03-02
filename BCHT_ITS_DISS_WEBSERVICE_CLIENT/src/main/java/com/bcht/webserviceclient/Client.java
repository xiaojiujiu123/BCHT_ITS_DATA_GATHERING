package com.bcht.webserviceclient;

import com.bcht.rabbitMQ.PropertiesUtils;
import com.bcht.rabbitMQ.XstreamUtils;
import org.apache.axis.AxisFault;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2017/5/16.
 */
public class Client {
    private static final String XML_PREFIX = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<root>\r\n";

    private static final String XML_PREFIX1 = "<?xml version=\"1.0\" encoding=\"GBK\"?>\r\n<root>\r\n";
    private static final String XML_END = "\r\n</root>";
    private static BchtRminfoImplServiceSoapBindingStub client = null;
    private static String url = PropertiesUtils.getValue("bcht_webservice_url");
    /**集中指挥平台的序列号*/
    private static String serializ = PropertiesUtils.getValue("rminf_webservice_serializ");
    public static void initClient(){
        try {
            client = new BchtRminfoImplServiceSoapBindingStub(new URL(url), null);
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public static String writerxml(Object obj) throws RemoteException {
        if(client==null){
            initClient();
        }
        String xml = XML_PREFIX + XstreamUtils.objectToXml(obj)+XML_END;
        String resultXML = client.writeObjectOut("60", serializ, "60W02", xml);
        return resultXML;
    }
    public static String queryxml(Object obj) throws RemoteException {
        if(client==null){
            initClient();
        }
        String xml = XML_PREFIX + XstreamUtils.objectToXml(obj)+XML_END;
        String resultXML = client.queryObjectOut("64", serializ, "64Q01", xml);
        return resultXML;
    }
}
