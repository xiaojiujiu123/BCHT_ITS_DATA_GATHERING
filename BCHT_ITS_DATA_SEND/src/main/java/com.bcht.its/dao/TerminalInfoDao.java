package com.bcht.its.dao;


import com.bcht.its.its.commons.beans.TerminalInfo;

import java.util.List;

/**
 * Created by scs on 2017/3/28.
 */
public interface TerminalInfoDao {
    public List<TerminalInfo> getTerminalInfo();
    public List<TerminalInfo> getLXTerminalInfo();
    public boolean saveTerminalInfo(TerminalInfo terminalInfo);
    public boolean updateTerminalInfo(TerminalInfo terminalInfo);
    public boolean delTerminalInfo(TerminalInfo terminalInfo);


}
