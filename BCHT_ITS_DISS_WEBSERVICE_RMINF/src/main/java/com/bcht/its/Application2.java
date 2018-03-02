package com.bcht.its;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 *  百诚慧通WebService服务，主要负责分发数据至
 */
@SpringBootApplication
//@EnableDiscoveryClient
public class Application2 {
    private static Logger logger = LoggerFactory.getLogger(Application2.class);
    private static final String XML_PREFIX = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<root>\r\n";
    private static final String XML_END = "\r\n</root>";
    public static final String  qvehbusXtlb= PropertiesUtils.getValue("qvehbus-xtlb");
    public static final String  qvehbusJkid= PropertiesUtils.getValue("qvehbus-jkid");

    public static final String  feedbackXtlb= PropertiesUtils.getValue("feedback-xtlb");
    public static final String  feedbackJkid= PropertiesUtils.getValue("feedback-jkid");

    public static final String  qstationXtlb= PropertiesUtils.getValue("qstation-xtlb");
    public static final String  qstationJkid= PropertiesUtils.getValue("qstation-jkid");

    public static final String  qstationrelationXtlb= PropertiesUtils.getValue("qstationrelation-xtlb");
    public static final String  qstationrelationJkid= PropertiesUtils.getValue("qstationrelation-jkid");

    public static final String  qstationpersonXtlb= PropertiesUtils.getValue("qstationperson-xtlb");
    public static final String  qstationpersonJkid= PropertiesUtils.getValue("qstationperson-jkid");

    public static final String  surscreeXtlb= PropertiesUtils.getValue("surscree-xtlb");
    public static final String  surscreeJkid= PropertiesUtils.getValue("surscree-jkid");

    public static final String  surexamineXtlb= PropertiesUtils.getValue("surexamine-xtlb");
    public static final String  surexamineJkid= PropertiesUtils.getValue("surexamine-jkid");

    public static final String  flowequipXtlb= PropertiesUtils.getValue("flowequip-xtlb");
    public static final String  flowequipJkid= PropertiesUtils.getValue("flowequip-jkid");

    public static final String  weatherXtlb= PropertiesUtils.getValue("weather-xtlb");
    public static final String  weatherJkid= PropertiesUtils.getValue("weather-jkid");

    public static final String  incidentXtlb= PropertiesUtils.getValue("incident-xtlb");
    public static final String  incidentJkid= PropertiesUtils.getValue("incident-jkid");

    public static final String  inducementXtlb= PropertiesUtils.getValue("inducement-xtlb");
    public static final String  inducementJkid= PropertiesUtils.getValue("inducement-jkid");

    public static final String  carXtlb= PropertiesUtils.getValue("car-xtlb");
    public static final String  carJkid= PropertiesUtils.getValue("car-jkid");

    public static final String  policeXtlb= PropertiesUtils.getValue("police-xtlb");
    public static final String  policeJkid= PropertiesUtils.getValue("police-jkid");

    public static final String  parkXtlb= PropertiesUtils.getValue("park-xtlb");
    public static final String  parkJkid= PropertiesUtils.getValue("park-jkid");

    public static final String  vehcheckXtlb= PropertiesUtils.getValue("vehcheck-xtlb");
    public static final String  vehcheckJkid= PropertiesUtils.getValue("vehcheck-jkid");

    public static final String  feedbackpicXtlb= PropertiesUtils.getValue("feedbackpic-xtlb");
    public static final String  feedbackpicJkid= PropertiesUtils.getValue("feedbackpic-jkid");

    public static final String  vehicleinfoXtlb= PropertiesUtils.getValue("vehicleinfo-xtlb");
    public static final String  vehicleinfoJkid= PropertiesUtils.getValue("vehicleinfo-jkid");

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        //start(args);
        if("start".equals(args[0])){
            start(args);
        }else{
            logger.info("应用程序停止……");
            stop();
        }
    }

   /* @Bean
    public BchtRminfoImpl bchtRminfoImpl(){
        return new BchtRminfoImpl();
    }
*/
    /**
     * 应用程序启动
     * @return
     */
    public static int start(String[] args){
        new SpringApplicationBuilder(Application2.class).web(true).run(args);
        return 1;
    }

    /**
     * 启用程序终止
     * @return
     */
    public static int stop(){
        return -1;
    }
}
