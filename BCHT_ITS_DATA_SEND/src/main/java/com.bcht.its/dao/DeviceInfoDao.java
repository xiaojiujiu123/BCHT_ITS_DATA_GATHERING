package com.bcht.its.dao;


import com.bcht.its.its.commons.beans.DeviceInfo;

import java.util.List;

/**
 * Created by scs on 2017/3/28.
 */
public interface DeviceInfoDao {
    public List<DeviceInfo> getZLDeviceInfo();
    public List<DeviceInfo> getDeviceInfoForTmnl();
    public List<DeviceInfo> getLXDeviceInfo();
    public void changDeviceState(String sbip, String state);
    public boolean saveDeviceInfo(DeviceInfo deviceInfo);
    public boolean updateDeviceInfo(DeviceInfo deviceInfo);
    public boolean delDeviceInfo(DeviceInfo deviceInfo);
    public DeviceInfo findBySbip(String ip);
    public List<DeviceInfo> getAllDeviceInfo();
}
