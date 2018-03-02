package com.bcht.webservice.rminf.client.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.converters.basic.StringBufferConverter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 车辆检查台账对象类
 * Created by zyq on 2017/5/2.
 */
@XStreamAlias("vehcheck")
public class VehcheckRequest {
    private String fwzbh;      //执法服务站编号     不可空
    private String clzt;       //车辆状态          不可空    1-正常 2-无牌 3-套牌 4-假
    private String hpzl;       //号牌种类          不可空
    private String hphm;       //号牌号码          不可空
    private String jccllx;     //检查车辆类型       不可空
    private String jcclzlx;   //检查车辆子类型
    private String sfd;        //始发地            不可空
    private String mdd;        //目的地            不可空
    private String zks;        //载客数
    private String sjzzl;      //实际载质量
    private String gps;        //GPS装备情况                1正常 0 不正常 9 未配备
    private String aqsb;       //安全设备配备情况            0不合格 1合格
    private String cllthw;     //车辆轮胎花纹情况            0 不合格 1合格
    private String wfyy;       //是否违法营运                0否 1是
    private String jaqd;       //驾驶人是否系安全带           0否 1是
    private String pljs;       //是否疲劳驾驶                0否 1是
    private String ffgz;       //是否非法改装                0否 1是
    private String ztfgbs;     //是否按规定粘贴反光标识       0否 1是
    private String azfhzz;     //是否安装侧后防护装置         0否 1是
    private String xgjsbz;     //是否悬挂或喷涂警示标志       0否 1是
    private String azdsj;      //是否按指定时间行驶           0否 1是
    private String azdlx;      //是否按指定路线行驶           0否 1是
    private String sfwzjs;     //是否无证驾驶                0否 1是
    private String sfyfjsy;    //是否有副驾驶员              0否 1是
    private String qdystxz;    //是否取得道路运输通行证        0否 1是
    private String sfyqwjy;    //是否逾期未检验               0否 1是
    private String sfyqwbf;    //是否逾期未报废               0否 1是
    private String sfwfwcl;    //是否违法未处理               0否 1是
    private String jcjg;       //是否重大按情       不可空    00-无，10-作案车辆 ，20-A级逃犯
    private String jcqkms;     //检查情况描述
    private String jcsj;       //检查时间           不可空     YYYY-MM-DDHH24:MI:SS
    private String jcmj;       //检查民警           不可空
    private String zjszh;      //主驾驶证号         不可空
    private String zlxdh;      //主驾驶联系电话
    private String zjssfcf;    //主驾驶是否超分
    private String zjssfyqwsy; //主驾驶是否逾期未审验
    private String zjssfyqwhz; //主驾驶是否逾期未换证
    private String zjszjbf;    //主驾驶准驾不符
    private String fjszh;      //副驾驶证号
    private String flxdh;      //副驾驶联系电话
    private String fjssfcf;    //副驾驶是否超分
    private String fjssfyqwsy; //副驾驶是否逾期未审验
    private String fjssfyqwhz; //副驾驶是否逾期未换证
    private String fjszjbf;    //副驾驶准驾不符
    private String dgzc;        //灯光是否正常
    private String zdzc;	//制动是否正常	1	是	0不正常 1正常
    private String zxzc;	//转向是否正常	1	是	0不正常 1正常
    private String sfjbc;	//是否接驳车辆		是	0否 1是
    private String bxpc;	//班线频次	1	是
    private String sftbjqx;	//是否投保交强险	1	是	0否 1是
    private String srzk;	//驶入站口	128	是
    private String sczk;	//驶出站口	128	是
    private String yxqy;	//运行区域	128	是
    private String yyxm;	//押运员姓名	30	是
    private String yydh;	//押运员电话	30	是
    private String yysfz;	//押运员证件	20	是
    private String whpzl;	//危化品种类	2	是
    private String whpmc;	//危化品名称	128	是
    private String chjg;	//是否嫌疑车辆	1	是	0 否 1是
    private String cljg;	//处置结果	10	是
    private String wsbh;	//法律文书编号	15	是
    private String jyw;	//文书校验位	1	是
    private String wslb;	//文书类别	1	是
    private String cfxylx;	//处罚嫌疑类型	2	是
    private String cfxyzlx; 	//处罚嫌疑子类型	2	是
    private String yjbm;	//移交部门	256	是
    private String lxr; 	//联系人	30	是
    private String lxdh;    //	联系电话	30	是	Cljg包含3时不能为空
    private String czqkms;	//处置情况描述	255	是


    public String getFwzbh() {
        return fwzbh;
    }

    public void setFwzbh(String fwzbh) throws UnsupportedEncodingException {
        this.fwzbh = URLEncoder.encode(fwzbh, "UTF-8");
    }

    public String getClzt() {
        return clzt;
    }

    public void setClzt(String clzt) throws UnsupportedEncodingException {
        this.clzt = URLEncoder.encode(clzt, "UTF-8");
    }

    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) throws UnsupportedEncodingException {
        this.hpzl = URLEncoder.encode(hpzl, "UTF-8");
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) throws UnsupportedEncodingException {
        this.hphm = URLEncoder.encode(hphm, "UTF-8");
    }


    public String getJccllx() {
        return jccllx;
    }

    public void setJccllx(String jccllx) throws UnsupportedEncodingException {
        this.jccllx = URLEncoder.encode(jccllx, "UTF-8");
    }
    public String getJcclzlx() {
        return jcclzlx;
    }

    public void setJcclzlx(String jcclzlx) throws UnsupportedEncodingException {
        this.jcclzlx = URLEncoder.encode(jcclzlx, "UTF-8");
    }

    public String getSfd() {
        return sfd;
    }

    public void setSfd(String sfd) throws UnsupportedEncodingException {
        this.sfd = URLEncoder.encode(sfd, "UTF-8");
    }

    public String getMdd() {
        return mdd;
    }

    public void setMdd(String mdd) throws UnsupportedEncodingException {
        this.mdd = URLEncoder.encode(mdd, "UTF-8");
    }

    public String getZks() {
        return zks;
    }

    public void setZks(String zks) throws UnsupportedEncodingException {
        this.zks = URLEncoder.encode(zks, "UTF-8");
    }

    public String getSjzzl() {
        return sjzzl;
    }

    public void setSjzzl(String sjzzl) throws UnsupportedEncodingException {
        this.sjzzl = URLEncoder.encode(sjzzl, "UTF-8");
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) throws UnsupportedEncodingException {
        this.gps = URLEncoder.encode(gps, "UTF-8");
    }

    public String getAqsb() {
        return aqsb;
    }

    public void setAqsb(String aqsb) throws UnsupportedEncodingException {
        this.aqsb = URLEncoder.encode(aqsb, "UTF-8");
    }

    public String getCllthw() {
        return cllthw;
    }

    public void setCllthw(String cllthw) throws UnsupportedEncodingException {
        this.cllthw = URLEncoder.encode(cllthw, "UTF-8");
    }

    public String getWfyy() {
        return wfyy;
    }

    public void setWfyy(String wfyy) throws UnsupportedEncodingException {
        this.wfyy = URLEncoder.encode(wfyy, "UTF-8");
    }

    public String getJaqd() {
        return jaqd;
    }

    public void setJaqd(String jaqd) throws UnsupportedEncodingException {
        this.jaqd = URLEncoder.encode(jaqd, "UTF-8");
    }

    public String getPljs() {
        return pljs;
    }

    public void setPljs(String pljs) throws UnsupportedEncodingException {
        this.pljs = URLEncoder.encode(pljs, "UTF-8");
    }

    public String getFfgz() {
        return ffgz;
    }

    public void setFfgz(String ffgz) throws UnsupportedEncodingException {
        this.ffgz = URLEncoder.encode(ffgz, "UTF-8");
    }

    public String getZtfgbs() {
        return ztfgbs;
    }

    public void setZtfgbs(String ztfgbs) throws UnsupportedEncodingException {
        this.ztfgbs = URLEncoder.encode(ztfgbs, "UTF-8");
    }

    public String getAzfhzz() {
        return azfhzz;
    }

    public void setAzfhzz(String azfhzz) throws UnsupportedEncodingException {
        this.azfhzz = URLEncoder.encode(azfhzz, "UTF-8");
    }

    public String getXgjsbz() {
        return xgjsbz;
    }

    public void setXgjsbz(String xgjsbz) throws UnsupportedEncodingException {
        this.xgjsbz = URLEncoder.encode(xgjsbz, "UTF-8");
    }

    public String getAzdsj() {
        return azdsj;
    }

    public void setAzdsj(String azdsj) throws UnsupportedEncodingException {
        this.azdsj = URLEncoder.encode(azdsj, "UTF-8");
    }

    public String getAzdlx() {
        return azdlx;
    }

    public void setAzdlx(String azdlx) throws UnsupportedEncodingException {
        this.azdlx = URLEncoder.encode(azdlx, "UTF-8");
    }

    public String getSfwzjs() {
        return sfwzjs;
    }

    public void setSfwzjs(String sfwzjs) throws UnsupportedEncodingException {
        this.sfwzjs = URLEncoder.encode(sfwzjs, "UTF-8");
    }

    public String getSfyfjsy() {
        return sfyfjsy;
    }

    public void setSfyfjsy(String sfyfjsy) throws UnsupportedEncodingException {
        this.sfyfjsy = URLEncoder.encode(sfyfjsy, "UTF-8");
    }

    public String getQdystxz() {
        return qdystxz;
    }

    public void setQdystxz(String qdystxz) throws UnsupportedEncodingException {
        this.qdystxz = URLEncoder.encode(qdystxz, "UTF-8");
    }

    public String getSfyqwjy() {
        return sfyqwjy;
    }

    public void setSfyqwjy(String sfyqwjy) throws UnsupportedEncodingException {
        this.sfyqwjy = URLEncoder.encode(sfyqwjy, "UTF-8");
    }

    public String getSfyqwbf() {
        return sfyqwbf;
    }

    public void setSfyqwbf(String sfyqwbf) throws UnsupportedEncodingException {
        this.sfyqwbf = URLEncoder.encode(sfyqwbf, "UTF-8");
    }

    public String getSfwfwcl() {
        return sfwfwcl;
    }

    public void setSfwfwcl(String sfwfwcl) throws UnsupportedEncodingException {
        this.sfwfwcl = URLEncoder.encode(sfwfwcl, "UTF-8");
    }

    public String getJcjg() {
        return jcjg;
    }

    public void setJcjg(String jcjg) throws UnsupportedEncodingException {
        this.jcjg = URLEncoder.encode(jcjg, "UTF-8");
    }

    public String getJcqkms() {
        return jcqkms;
    }

    public void setJcqkms(String jcqkms) throws UnsupportedEncodingException {
        this.jcqkms = URLEncoder.encode(jcqkms, "UTF-8");
    }

    public String getJcsj() {
        return jcsj;
    }

    public void setJcsj(String jcsj) throws UnsupportedEncodingException {
        this.jcsj = URLEncoder.encode(jcsj, "UTF-8");
    }

    public String getJcmj() {
        return jcmj;
    }

    public void setJcmj(String jcmj) throws UnsupportedEncodingException {
        this.jcmj = URLEncoder.encode(jcmj, "UTF-8");
    }

    public String getZjszh() {
        return zjszh;
    }

    public void setZjszh(String zjszh) throws UnsupportedEncodingException {
        this.zjszh = URLEncoder.encode(zjszh, "UTF-8");
    }

    public String getZlxdh() {
        return zlxdh;
    }

    public void setZlxdh(String zlxdh) throws UnsupportedEncodingException {
        this.zlxdh = URLEncoder.encode(zlxdh, "UTF-8");
    }

    public String getZjssfcf() {
        return zjssfcf;
    }

    public void setZjssfcf(String zjssfcf) throws UnsupportedEncodingException {
        this.zjssfcf = URLEncoder.encode(zjssfcf, "UTF-8");
    }

    public String getZjssfyqwsy() {
        return zjssfyqwsy;
    }

    public void setZjssfyqwsy(String zjssfyqwsy) throws UnsupportedEncodingException {
        this.zjssfyqwsy = URLEncoder.encode(zjssfyqwsy, "UTF-8");
    }

    public String getZjssfyqwhz() {
        return zjssfyqwhz;
    }

    public void setZjssfyqwhz(String zjssfyqwhz) throws UnsupportedEncodingException {
        this.zjssfyqwhz = URLEncoder.encode(zjssfyqwhz, "UTF-8");
    }

    public String getZjszjbf() {
        return zjszjbf;
    }

    public void setZjszjbf(String zjszjbf) throws UnsupportedEncodingException {
        this.zjszjbf = URLEncoder.encode(zjszjbf, "UTF-8");
    }

    public String getFjszh() {
        return fjszh;
    }

    public void setFjszh(String fjszh) throws UnsupportedEncodingException {
        this.fjszh = URLEncoder.encode(fjszh, "UTF-8");
    }

    public String getFlxdh() {
        return flxdh;
    }

    public void setFlxdh(String flxdh) throws UnsupportedEncodingException {
        this.flxdh = URLEncoder.encode(flxdh, "UTF-8");
    }

    public String getFjssfcf() {
        return fjssfcf;
    }

    public void setFjssfcf(String fjssfcf) throws UnsupportedEncodingException {
        this.fjssfcf = URLEncoder.encode(fjssfcf, "UTF-8");
    }

    public String getFjssfyqwsy() {
        return fjssfyqwsy;
    }

    public String getDgzc() {
        return dgzc;
    }

    public void setDgzc(String dgzc) throws UnsupportedEncodingException {
        this.dgzc = URLEncoder.encode(dgzc, "UTF-8");
    }

    public void setFjssfyqwsy(String fjssfyqwsy) throws UnsupportedEncodingException {
        this.fjssfyqwsy = URLEncoder.encode(fjssfyqwsy, "UTF-8");
    }

    public String getFjssfyqwhz() {
        return fjssfyqwhz;
    }

    public void setFjssfyqwhz(String fjssfyqwhz) throws UnsupportedEncodingException {
        this.fjssfyqwhz = URLEncoder.encode(fjssfyqwhz, "UTF-8");
    }

    public String getFjszjbf() {
        return fjszjbf;
    }

    public void setFjszjbf(String fjszjbf) throws UnsupportedEncodingException {
        this.fjszjbf = URLEncoder.encode(fjszjbf, "UTF-8");
    }

    public String getZdzc() {
        return zdzc;
    }

    public void setZdzc(String zdzc) throws UnsupportedEncodingException {
        this.zdzc = URLEncoder.encode(zdzc, "UTF-8");
    }

    public String getZxzc() {
        return zxzc;
    }

    public void setZxzc(String zxzc) throws UnsupportedEncodingException {
        this.zxzc = URLEncoder.encode(zxzc, "UTF-8");
    }

    public String getSfjbc() {
        return sfjbc;
    }

    public void setSfjbc(String sfjbc) throws UnsupportedEncodingException {
        this.sfjbc = URLEncoder.encode(sfjbc, "UTF-8");
    }

    public String getBxpc() {
        return bxpc;
    }

    public void setBxpc(String bxpc) throws UnsupportedEncodingException {
        this.bxpc = URLEncoder.encode(bxpc, "UTF-8");
    }

    public String getSftbjqx() {
        return sftbjqx;
    }

    public void setSftbjqx(String sftbjqx) throws UnsupportedEncodingException {
        this.sftbjqx = URLEncoder.encode(sftbjqx, "UTF-8");
    }

    public String getSrzk() {
        return srzk;
    }

    public void setSrzk(String srzk) throws UnsupportedEncodingException {
        this.srzk = URLEncoder.encode(srzk, "UTF-8");
    }

    public String getSczk() {
        return sczk;
    }

    public void setSczk(String sczk) throws UnsupportedEncodingException {
        this.sczk = URLEncoder.encode(sczk, "UTF-8");
    }

    public String getYxqy() {
        return yxqy;
    }

    public void setYxqy(String yxqy) throws UnsupportedEncodingException {
        this.yxqy = URLEncoder.encode(yxqy, "UTF-8");
    }

    public String getYyxm() {
        return yyxm;
    }

    public void setYyxm(String yyxm) throws UnsupportedEncodingException {
        this.yyxm = URLEncoder.encode(yyxm, "UTF-8");
    }

    public String getYydh() {
        return yydh;
    }

    public void setYydh(String yydh) throws UnsupportedEncodingException {
        this.yydh = URLEncoder.encode(yydh, "UTF-8");
    }

    public String getYysfz() {
        return yysfz;
    }

    public void setYysfz(String yysfz) throws UnsupportedEncodingException {
        this.yysfz = URLEncoder.encode(yysfz, "UTF-8");
    }

    public String getWhpzl() {
        return whpzl;
    }

    public void setWhpzl(String whpzl) throws UnsupportedEncodingException {
        this.whpzl = URLEncoder.encode(whpzl, "UTF-8");
    }

    public String getWhpmc() {
        return whpmc;
    }

    public void setWhpmc(String whpmc) throws UnsupportedEncodingException {
        this.whpmc = URLEncoder.encode(whpmc, "UTF-8");
    }

    public String getChjg() {
        return chjg;
    }

    public void setChjg(String chjg) throws UnsupportedEncodingException {
        this.chjg = URLEncoder.encode(chjg, "UTF-8");
    }

    public String getCljg() {
        return cljg;
    }

    public void setCljg(String cljg) throws UnsupportedEncodingException {
        this.cljg = URLEncoder.encode(cljg, "UTF-8");
    }

    public String getWsbh() {
        return wsbh;
    }

    public void setWsbh(String wsbh) throws UnsupportedEncodingException {
        this.wsbh = URLEncoder.encode(wsbh, "UTF-8");
    }

    public String getJyw() {
        return jyw;
    }

    public void setJyw(String jyw) throws UnsupportedEncodingException {
        this.jyw = URLEncoder.encode(jyw, "UTF-8");
    }

    public String getWslb() {
        return wslb;
    }

    public void setWslb(String wslb) throws UnsupportedEncodingException {
        this.wslb = URLEncoder.encode(wslb, "UTF-8");
    }

    public String getCfxylx() {
        return cfxylx;
    }

    public void setCfxylx(String cfxylx) throws UnsupportedEncodingException {
        this.cfxylx = URLEncoder.encode(cfxylx, "UTF-8");
    }

    public String getCfxyzlx() {
        return cfxyzlx;
    }

    public void setCfxyzlx(String cfxyzlx) throws UnsupportedEncodingException {
        this.cfxyzlx = URLEncoder.encode(cfxyzlx, "UTF-8");
    }

    public String getYjbm() {
        return yjbm;
    }

    public void setYjbm(String yjbm) throws UnsupportedEncodingException {
        this.yjbm = URLEncoder.encode(yjbm, "UTF-8");
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) throws UnsupportedEncodingException {
        this.lxr = URLEncoder.encode(lxr, "UTF-8");
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) throws UnsupportedEncodingException {
        this.lxdh = URLEncoder.encode(lxdh, "UTF-8");
    }

    public String getCzqkms() {
        return czqkms;
    }

    public void setCzqkms(String czqkms) throws UnsupportedEncodingException {
        this.czqkms = URLEncoder.encode(czqkms, "UTF-8");
    }
}
